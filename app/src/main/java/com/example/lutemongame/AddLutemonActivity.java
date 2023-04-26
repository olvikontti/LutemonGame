package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddLutemonActivity extends AppCompatActivity {

    private EditText nameTxt;
    private EditText ageTxt;
    private EditText gameNumberTxt;
    private RadioGroup colorRg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lutemon);

        nameTxt = findViewById(R.id.txtLutemonName);
        ageTxt = findViewById(R.id.txtAge);
        gameNumberTxt = findViewById(R.id.txtGameNumber);
        colorRg = findViewById(R.id.rgColors);


    }

    public void addLutemon(View view) {

        String name = nameTxt.getText().toString();
        String age = ageTxt.getText().toString();
        String gameNumber = gameNumberTxt.getText().toString();

        String color = colorRg.toString();

        switch (colorRg.getCheckedRadioButtonId()) {
            case R.id.rbWhite:
                color = "Valkoinen";
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

        Lutemon lutemon = new Lutemon(name, color, age, gameNumber);
        LutemonStorage.getInstance().addLutemon(lutemon);
    }
}