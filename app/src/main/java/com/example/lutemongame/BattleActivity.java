package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {

    private ArrayList<String> lutemonsForBattle = new ArrayList<>();
    private TextView battleTxt;
    private int lutemonId1;
    private int LutemonId2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        LinearLayout listLayout = findViewById(R.id.trainingListLayout);
        LinearLayout battleLayout = findViewById(R.id.battleLayout);
        battleTxt = findViewById(R.id.txtBattle);

        // Creates the checkbox list of available lutemons
        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            CheckBox cb = new CheckBox(this);
            cb.setId(i);
            cb.setText(LutemonStorage.getInstance().getLutemon(i).getName());
            listLayout.addView(cb);
        }

        Button btnBattle = findViewById(R.id.btnStartBattle);
        btnBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (battleLayout.getChildCount() > 0) {
                    battleLayout.removeAllViews();
                }
                lutemonsForBattle.clear();

                // Adds lutemons to list
                for (int i = 0; i < listLayout.getChildCount(); i++) {
                    View v = listLayout.getChildAt(i);
                    if (view instanceof CheckBox) {
                        CheckBox cb = (CheckBox) view;
                        if (cb.isChecked()) {
                            int id = cb.getId();
                            String name = LutemonStorage.getInstance().getLutemon(id).getName();
                            lutemonsForBattle.add(name);
                        }
                    }
                }
            }
        });

    }

}