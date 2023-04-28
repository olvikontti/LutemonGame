package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MoveLutemonsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);
    }


    public void switchToHome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void switchToTraining(View view) {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    public void switchToBattle(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }
}