package com.example.lutemongame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private EditText userNametxt;
    private EditText passwordtxt;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        LutemonStorage.getInstance().loadLutemons(this);

        userNametxt = findViewById(R.id.txtUserName);
        passwordtxt = findViewById(R.id.txtPassword);
        loginbtn = findViewById(R.id.btnLogin);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = userNametxt.getText().toString();
                String password = passwordtxt.getText().toString();


                if (username.equals("testi") && password.equals("testi")) {
                    switchToMenu(view);
                } else {
                    Toast.makeText(MainActivity.this, "Väärä käyttäjänimi tai salasana", Toast.LENGTH_SHORT).show();
                }
            }
        });
}

    public void switchToMenu(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}

