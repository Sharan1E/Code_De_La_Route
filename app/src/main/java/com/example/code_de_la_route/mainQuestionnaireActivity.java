package com.example.code_de_la_route;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;


public class mainQuestionnaireActivity extends AppCompatActivity {

    //VILLE est une clé qui sert à transmettre la valeur selectionnée
    final String VILLE = "ville";
    String themechoisi = "theme";
    int questionactuelle = 0;
    List<Question_element> quizz_theme1;

    public void ShuffleAnswer(RadioButton[] radioButton)
    {
        for (int i = 0; i < 4; i++) {//this loop is randomly changing values 4 times
            int swap_ind1 = ((int) (Math.random() * 10) % 4);
            int swap_ind2 = ((int) (Math.random() * 10) % 4);
            String temp = (String) radioButton[swap_ind1].getText();
            radioButton[swap_ind1].setText(radioButton[swap_ind2].getText());
            radioButton[swap_ind2].setText(temp);
        }
    }

    public void DisplayQuestion()
    {
        themechoisi = Theme_Choice_Activity.getThemeChoisi();

        final RadioGroup GroupQuestion = (RadioGroup) findViewById(R.id.GroupQuestion);
        final RadioButton reponse1 = (RadioButton) findViewById(R.id.buttonRoll);
        final RadioButton reponse2 = (RadioButton) findViewById(R.id.buttonRoll2);
        final RadioButton reponse3 = (RadioButton) findViewById(R.id.buttonRoll3);
        final RadioButton reponse4 = (RadioButton) findViewById(R.id.buttonRoll4);
        final RadioButton[] radioButton = {reponse1,reponse2,reponse3,reponse4};
        final Button next = (Button) findViewById(R.id.buttonNext);

        if(themechoisi.equals("Thème n°1:"))
        {
            GroupQuestion.clearCheck();

            reponse1.setText(quizz_theme1.get(questionactuelle).getAnswer1());
            reponse2.setText(quizz_theme1.get(questionactuelle).getAnswer2());
            reponse3.setText(quizz_theme1.get(questionactuelle).getAnswer3());
            reponse4.setText(quizz_theme1.get(questionactuelle).getAnswer4());
            ShuffleAnswer(radioButton);
        }

        //on définit ce qu'il va se passer quand l'action clickSurBouton1 est déclenchée
        View.OnClickListener clickSurReponse1  = v -> {
            //quand on clique sur le bouton 1 on passe a l'activite resultat (reponse1Activity)
            // en passant comme parametre le texte du bouton 1
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse1.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton2 est déclenchée
        View.OnClickListener clickSurReponse2  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse2.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton3 est déclenchée
        View.OnClickListener clickSurReponse3  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse3.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton3 est déclenchée
        View.OnClickListener clickSurNext  = v -> {

            ShuffleAnswer(radioButton);
            questionactuelle++;
            DisplayQuestion();
        };

        //associe au bouton reponse l'action clickSurBouton1
        reponse1.setOnClickListener(clickSurReponse1);
        reponse2.setOnClickListener(clickSurReponse2);
        reponse3.setOnClickListener(clickSurReponse3);
        next.setOnClickListener(clickSurNext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monquestionnaire);

        quizz_theme1 = new ArrayList<>();
        Question_element theme1 = new Question_element("Question1", "Quelle est la capitale de la France ?", "Paris","Marseille","Lyon","Bordeaux");
        Question_element theme2 = new Question_element("Question2","Choisir ville de fermier", "Mayenne","luxembourg","Saint-Denis","Monfermeil");

        quizz_theme1.add(theme1);
        quizz_theme1.add(theme2);

        DisplayQuestion();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(mainQuestionnaireActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
