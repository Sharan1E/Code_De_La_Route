package com.example.code_de_la_route;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Informations_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations);


        Button button = findViewById(R.id.button_back_from_info);
        button.setOnClickListener(view -> openMainActivity());
    }

    public void openMainActivity(){
        Intent intent = new Intent(Informations_Activity.this,MainActivity.class);
        startActivity(intent);
    }
}