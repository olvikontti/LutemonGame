package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private ArrayList<String> lutemonsForBattle = new ArrayList<>();
    private int lutemonId1;
    private int lutemonId2;
    private int j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        LinearLayout listLayout = findViewById(R.id.trainingListLayout);
        LinearLayout battleLayout = findViewById(R.id.battleListLayout);

        // Creates the checkbox list of available lutemons
        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            CheckBox cb = new CheckBox(BattleActivity.this);
            cb.setId(i);
            cb.setText(LutemonStorage.getInstance().getLutemon(i).getName() + " (" + LutemonStorage.getInstance().getLutemon(i).getColor() + ")");
            listLayout.addView(cb);
        }

        Button btnBattle = findViewById(R.id.btnStartBattle);
        btnBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lutemonsForBattle.clear();
                if (battleLayout.getChildCount() > 0) {
                    battleLayout.removeAllViews();
                }

                // Adds lutemons to list
                for (int i = 0; i < listLayout.getChildCount(); i++) {
                    View v = listLayout.getChildAt(i);
                    if (v instanceof CheckBox) {
                        CheckBox cb = (CheckBox) v;
                        if (cb.isChecked()) {
                            int id = cb.getId();
                            String lutemon = LutemonStorage.getInstance().getLutemon(id).getName();
                            lutemonsForBattle.add(lutemon);
                        }
                    }
                }
                // Checks if the number of selected lutemons is two
                if (lutemonsForBattle.size() == 2) {
                    Toast.makeText(BattleActivity.this, "Taistelu alkaa!", Toast.LENGTH_SHORT).show();
                    getLutemonsId();
                    Lutemon lutemon1 = LutemonStorage.getInstance().getLutemon(lutemonId1);
                    Lutemon lutemon2 = LutemonStorage.getInstance().getLutemon(lutemonId2);
                    addTextView(lutemon1.getName(), lutemon1.getAttack(), lutemon1.getDefense(), lutemon1.getExperience(), lutemon1.getHealth(), lutemon1.getMaxHealth());
                    addTextView(lutemon2.getName(), lutemon2.getAttack(), lutemon2.getDefense(), lutemon2.getExperience(), lutemon2.getHealth(), lutemon2.getMaxHealth());
                    // Battle
                    while (lutemon1.getHealth() > 0 && lutemon2.getHealth() > 0) {


                        // Lutemons attack and defend alternately
                        if (j % 2 == 0) {
                            lutemon1.defend(lutemon2.getAttack());
                            addText(lutemon1.getName(), lutemon2.getName(), lutemon1.getAttack(), 1);
                            addText(lutemon2.getName(), "", 0, 2);

                        } else {
                            lutemon2.defend(lutemon1.getAttack());
                            addText(lutemon2.getName(), lutemon1.getName(), lutemon2.getAttack(), 1);
                            addText(lutemon1.getName(), "", 0, 2);

                        }

                        // Checks if lutemon dies
                        if (lutemon1.getHealth() <= 0) {
                            addText(lutemon1.getName(), lutemon2.getName(), 0, 3);
                            lutemon2.setExperience();
                            lutemon2.health = lutemon2.maxHealth;
                            LutemonStorage.getInstance().deleteLutemon(lutemon1);
                            LutemonStorage.getInstance().saveLutemons(BattleActivity.this);

                        }
                        if (lutemon2.getHealth() <= 0) {
                            addText(lutemon2.getName(), lutemon1.getName(), 0, 3);
                            lutemon1.setExperience();
                            lutemon1.health = lutemon1.maxHealth;
                            LutemonStorage.getInstance().deleteLutemon(lutemon2);
                            LutemonStorage.getInstance().saveLutemons(BattleActivity.this);
                        }


                        j++;
                    }
                } else {
                    Toast.makeText(BattleActivity.this, "Valitse kaksi taistelijaa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void getLutemonsId() {
        lutemonId1 = -1;
        LinearLayout layout = findViewById(R.id.trainingListLayout);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View v = layout.getChildAt(i);
            if (v instanceof CheckBox) {
                CheckBox cb = (CheckBox) v;
                if (cb.isChecked()) {
                    if (lutemonId1 == -1) {
                        lutemonId1 = cb.getId();
                    } else {
                        lutemonId2 = cb.getId();
                        break;
                    }
                }
            }
        }
    }

    private void addTextView(String name, int att, int def, int exp, int health, int maxHealth) {
        TextView battleText = new TextView(BattleActivity.this);
        LinearLayout textLayout = findViewById(R.id.textLayout);
        battleText.setText(name + " att: " + att + "; def: " + def + "; exp: " + exp + "; health: " + health + "/" + maxHealth);
        textLayout.addView(battleText);
    }

    private void addText(String att, String def, int damage, int print) {
        TextView battleText = new TextView(BattleActivity.this);
        LinearLayout layout = findViewById(R.id.battleListLayout);
        if (print == 1) {
            battleText.setText(att + " attacks " + def + " for " + damage + " damage.");
        } else if (print == 2) {
            battleText.setText(att + " manages to escape death.\n");
        } else if (print == 3) {
            battleText.setText(att + " gets killed and " + def + " won!");
        }
        layout.addView(battleText);
    }
}