package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText nameTxt;
    private RadioGroup colorRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        nameTxt = findViewById(R.id.txtLutemonName);
        colorRg = findViewById(R.id.rgColors);


    }
    public void addLutemon(View view) {

        String name = nameTxt.getText().toString();
        //String color = colorRg.toString();

        switch (colorRg.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                LutemonStorage.getInstance().addLutemon(new White);
                break;
            case R.id.rbGreen:
                color = "Vihreä";
                break;
            case R.id.rbPink:
                color = "Pinkki";
                break;
            case R.id.rbOrange:
                color = "Oranssi";
                break;
            case R.id.rbBlack:
                color = "Musta";
                break;
        }

        //Lutemon lutemon = new Lutemon(name, color);
        //LutemonStorage.getInstance().addLutemon(lutemon);
        LutemonStorage.getInstance().saveLutemons(this);
    }
}