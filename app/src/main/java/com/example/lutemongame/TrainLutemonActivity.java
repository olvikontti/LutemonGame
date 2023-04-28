package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
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

        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            RadioButton rb = new RadioButton(this);
            rb.setId(i);
            rb.setText(LutemonStorage.getInstance().getLutemon(i).getName() + " (" + LutemonStorage.getInstance().getLutemon(i).getColor() +")");
            rgLutemonlist.addView(rb);
        }

        btnImproveAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgLutemonlist.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(TrainLutemonActivity.this, "Please select a Lutemon to train", Toast.LENGTH_SHORT).show();
                } else {
                    Lutemon lutemon = LutemonStorage.getInstance().getLutemon(selectedId);
                    System.out.println(lutemon.getName());
                    System.out.println("testitesti");
                    LutemonStorage.getInstance().TrainingLutemonAttack(lutemon);
                    Toast.makeText(TrainLutemonActivity.this, lutemon.getName() + "'s attack has been improved!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnImproveDefence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgLutemonlist.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(TrainLutemonActivity.this, "Please select a Lutemon to train", Toast.LENGTH_SHORT).show();
                } else {
                    Lutemon lutemon = LutemonStorage.getInstance().getLutemon(selectedId);
                    LutemonStorage.getInstance().TrainingLutemonDefence(lutemon);
                    Toast.makeText(TrainLutemonActivity.this, lutemon.getName() + "'s defence has been improved!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

