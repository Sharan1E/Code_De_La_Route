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

        Button info_button = findViewById(R.id.button_info_from_home_page);
        info_button.setOnClickListener(view -> openInformationsActivity());

        Button exam_button = findViewById(R.id.button_exam_from_home_page);
        exam_button.setOnClickListener(view -> openExamActivity());

        Button training_button = findViewById(R.id.button_training_from_home_page);
        training_button.setOnClickListener(view -> openThemeChoiceActivity());
    }

    public void openInformationsActivity(){
        Intent intent = new Intent(MainActivity.this,Informations_Activity.class);
        startActivity(intent);
    }

    public void openExamActivity(){
        Intent intent = new Intent(MainActivity.this,mainQuestionnaireActivity.class);
        intent.putExtra("FROM_ACTIVITY","Examen Blanc");
        startActivity(intent);
    }

    public void openThemeChoiceActivity(){
        Intent intent = new Intent(MainActivity.this,Theme_Choice_Activity.class);
        startActivity(intent);
    }
}