package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class HomeActivity extends AppCompatActivity {

    private RadioGroup homeRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeRg = findViewById(R.id.rgHome);

        LinearLayout listLayout = findViewById(R.id.homeListLayout);

        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            CheckBox cb = new CheckBox(this);
            cb.setId(i);
            cb.setText(LutemonStorage.getInstance().getLutemon(i).getName());
            listLayout.addView(cb);
        }



        /*switch (homeRg.getCheckedRadioButtonId()){
            case R.id.rbToTraining:
                LutemonStorage.getInstance().moveLutemons("home", "training", lutemon);
            case R.id.rbToBattle:
                LutemonStorage.getInstance().moveLutemons("home", "battle", lutemon);

        }*/
    }






}