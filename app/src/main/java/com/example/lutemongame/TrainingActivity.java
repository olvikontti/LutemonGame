package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class TrainingActivity extends AppCompatActivity {

    private RadioGroup trainingRg;

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

        switch (trainingRg.getCheckedRadioButtonId()){
            case R.id.rbHome:
                LutemonStorage.getInstance().moveLutemons("training", "home", lutemon);
            case R.id.rbBattle:
                LutemonStorage.getInstance().moveLutemons("training", "battle", lutemon);

        }



    }
}
