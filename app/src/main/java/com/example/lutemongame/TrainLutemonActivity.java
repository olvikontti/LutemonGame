package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TrainLutemonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemon);

        RadioGroup rgLutemonlist = findViewById(R.id.rgTrainingList);
        Button btnImproveAttack = findViewById(R.id.btnImproveAttack);
        Button btnImproveDefence = findViewById(R.id.btnImproveDefence);
        Button btnImrpoveEndurance = findViewById(R.id.btnImproveEndurance);

        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            RadioButton rb = new RadioButton(this);
            rb.setId(i);
            rb.setText(LutemonStorage.getInstance().getLutemon(i).getName() + " (" + LutemonStorage.getInstance().getLutemon(i).getColor() +")");
            rgLutemonlist.addView(rb);
        }

        //Improves attack of the selected lutemon
        btnImproveAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgLutemonlist.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(TrainLutemonActivity.this, "Valitse Lutemoni, jota treenataan", Toast.LENGTH_SHORT).show();
                } else {
                    Lutemon lutemon = LutemonStorage.getInstance().getLutemon(selectedId);
                    System.out.println(lutemon.getName());

                    LutemonStorage.getInstance().trainAttack(lutemon);
                    Toast.makeText(TrainLutemonActivity.this, lutemon.getName() + " hyökkäystä on kehitetty!", Toast.LENGTH_SHORT).show();
                    LutemonStorage.getInstance().saveLutemons(TrainLutemonActivity.this);
                }
            }

        });

        //Improves defense of the selected lutemon
        btnImproveDefence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgLutemonlist.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(TrainLutemonActivity.this, "Valitse Lutemoni, jota treenataan", Toast.LENGTH_SHORT).show();
                } else {
                    Lutemon lutemon = LutemonStorage.getInstance().getLutemon(selectedId);
                    LutemonStorage.getInstance().trainDefence(lutemon);
                    Toast.makeText(TrainLutemonActivity.this, lutemon.getName() + " puolustusta on kehitetty!", Toast.LENGTH_SHORT).show();
                    LutemonStorage.getInstance().saveLutemons(TrainLutemonActivity.this);
                }
            }
        });


        //Improves endurance (max health) of the selected lutemon
        btnImrpoveEndurance.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int selectedId = rgLutemonlist.getCheckedRadioButtonId();
                if(selectedId == -1){
                    Toast.makeText(TrainLutemonActivity.this, "Valitse Lutemoni, jota treenataan", Toast.LENGTH_SHORT).show();
                } else {
                    Lutemon lutemon = LutemonStorage.getInstance().getLutemon(selectedId);
                    LutemonStorage.getInstance().trainEndurance(lutemon);
                    Toast.makeText(TrainLutemonActivity.this, lutemon.getName() + " kestävyyttä on kehitetty!", Toast.LENGTH_SHORT).show();
                    LutemonStorage.getInstance().saveLutemons(TrainLutemonActivity.this);
                }
            }
        });


    }
}

