package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class TrainingActivity extends AppCompatActivity {

    private RadioGroup trainingRg;

    ArrayList<Lutemon> lutemonT = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        trainingRg = findViewById(R.id.rgTraining);

        LinearLayout listLayout = findViewById(R.id.trainingLayout);

        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            CheckBox cb = new CheckBox(this);
            cb.setId(i);
            cb.setText(LutemonStorage.getInstance().getLutemon(i).getName());
            listLayout.addView(cb);
        }

        for (int j = 0; j < listLayout.getChildCount(); j++){
            if(listLayout.getChildAt(j) instanceof CheckBox){
                CheckBox cb = (CheckBox) listLayout.getChildAt(j);
                if(cb.isChecked()){
                    lutemonT.add(LutemonStorage.getInstance().getLutemon(cb.getId()));
                }
            }
        }

        switch (trainingRg.getCheckedRadioButtonId()){
            case R.id.rbHome:
                LutemonStorage.getInstance().moveLutemons("training", "home", lutemonT);
            case R.id.rbBattle:
                LutemonStorage.getInstance().moveLutemons("training", "battle", lutemonT);

        }



    }
}
