package com.example.code_de_la_route;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_info_from_home_page);
        button.setOnClickListener(view -> openInformationsActivity());
    }

    public void openInformationsActivity(){
        Intent intent = new Intent(MainActivity.this,Informations_Activity.class);
        startActivity(intent);
    }
}