package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RadioGroup homeRg;
    ArrayList<Lutemon> lutemonH = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeRg = findViewById(R.id.rgHome);
        Button btnMoveFromHome = findViewById(R.id.btnMoveFromHome);

        LinearLayout listLayout = findViewById(R.id.homeListLayout);

        for (int i = 0; i < LutemonStorage.getInstance().getLutemons().size(); i++) {
            CheckBox cb = new CheckBox(this);
            cb.setId(i);
            cb.setText(LutemonStorage.getInstance().getLutemon(i).getName() + " (" + LutemonStorage.getInstance().getLutemon(i).getColor() +")");
            listLayout.addView(cb);
        }

        for (int j = 0; j < listLayout.getChildCount(); j++){
            if(listLayout.getChildAt(j) instanceof CheckBox){
                CheckBox cb = (CheckBox) listLayout.getChildAt(j);
                if(cb.isChecked()){
                    lutemonH.add(LutemonStorage.getInstance().getLutemon(cb.getId()));
                }
            }
        }





        btnMoveFromHome.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch (homeRg.getCheckedRadioButtonId()){
                    case R.id.rbToTraining:
                        LutemonStorage.getInstance().moveLutemons("home", "training", lutemonH);
                    case R.id.rbToBattle:
                        LutemonStorage.getInstance().moveLutemons("home", "battle", lutemonH);

                }
            }
        });
    }



}