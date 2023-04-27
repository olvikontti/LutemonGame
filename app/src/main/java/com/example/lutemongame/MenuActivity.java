package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void switchToAddLutemon(View view) {
        Intent intent = new Intent(this, AddLutemonActivity.class);
        startActivity(intent);
    }

    public void switchToLutemonList(View view) {
        Intent intent = new Intent(this, LutemonListActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemons(View view) {
        Intent intent = new Intent(this, MoveLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToBattle(View view) {
        Intent intent = new Intent(this, BattleActivity.class);
        startActivity(intent);
    }
}