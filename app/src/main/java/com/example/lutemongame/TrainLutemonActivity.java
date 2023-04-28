package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TrainLutemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_lutemon);

        RadioGroup rgLutemonlist = findViewById(R.id.rgTrainingList);

        for (int i = 0; i < LutemonStorage.getInstance().getSize(); i++) {
            RadioButton rb = new RadioButton(this);
            rb.setId(i);
            rb.setText(LutemonStorage.getInstance().getLutemon(i).getName());
            rgLutemonlist.addView(rb);
        }
    }
}
