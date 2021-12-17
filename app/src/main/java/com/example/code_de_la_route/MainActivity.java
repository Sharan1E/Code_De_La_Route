package com.example.code_de_la_route;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static int choixmode;

    public static int getChoixmode() {
        return choixmode;
    }

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
        Intent intent = new Intent(MainActivity.this, InformationsActivity.class);
        startActivity(intent);
    }

    public void openExamActivity(){
        Intent intent = new Intent(MainActivity.this, QuizzActivity.class);
        choixmode=0;
        startActivity(intent);
    }

    public void openThemeChoiceActivity(){
        Intent intent = new Intent(MainActivity.this, ThemeChoiceActivity.class);
        choixmode=1;
        startActivity(intent);
    }

}