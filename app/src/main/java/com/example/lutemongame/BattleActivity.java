package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        LinearLayout listLayout = findViewById(R.id.listLayout);

        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            CheckBox cb = new CheckBox(this);
            cb.setId(i);
            cb.setText(LutemonStorage.getInstance().getLutemon(i).getName());
            listLayout.addView(cb);
        }


    }

}