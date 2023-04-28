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
        int id = LutemonStorage.getInstance().getLutemons().size() + 1;
        //String color = colorRg.toString();
        System.out.println("testiprintti");

        switch (colorRg.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                LutemonStorage.getInstance().addLutemon(new White(name, id));
                break;
            case R.id.rbGreen:
                LutemonStorage.getInstance().addLutemon(new Green(name, id));
                break;
            case R.id.rbPink:
                LutemonStorage.getInstance().addLutemon(new Pink(name, id));
                break;
            case R.id.rbOrange:
                LutemonStorage.getInstance().addLutemon(new Orange(name, id));
                break;
            case R.id.rbBlack:
                LutemonStorage.getInstance().addLutemon(new Black(name, id));
                break;
        }
        System.out.println("testiiiiii");
        LutemonStorage.getInstance().saveLutemons(this);
        System.out.println("testi3");
    }
}