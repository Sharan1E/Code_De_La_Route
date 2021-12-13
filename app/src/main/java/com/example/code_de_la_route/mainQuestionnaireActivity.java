package com.example.code_de_la_route;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class mainQuestionnaireActivity extends AppCompatActivity {

    //VILLE est une clé qui sert à transmettre la valeur selectionnée
    final String VILLE = "ville";
    String themechoisi = "theme";
    int questionactuelle = 0;
    List<Question_element> quizz_theme1;

    public void ShuffleAnswer(CheckBox[] checkBoxes)
    {
        for (int i = 0; i < checkBoxes.length; i++) {//this loop is randomly changing values 4 times
            int swap_ind1 = ((int) (Math.random() * 10) % checkBoxes.length);
            int swap_ind2 = ((int) (Math.random() * 10) % checkBoxes.length);
            String temp = (String) checkBoxes[swap_ind1].getText();
            checkBoxes[swap_ind1].setText(checkBoxes[swap_ind2].getText());
            checkBoxes[swap_ind2].setText(temp);
        }
    }

    public void DisplayQuestion()
    {
        themechoisi = Theme_Choice_Activity.getThemeChoisi();

        final TextView questionTitle1 = (TextView) findViewById(R.id.questionTitle1);
        final TextView questionTitle2 = (TextView) findViewById(R.id.questionTitle2);
        final TextView questionNumber = (TextView) findViewById(R.id.questionNumber);
        final RadioGroup GroupQuestion = (RadioGroup) findViewById(R.id.GroupQuestion);

        final CheckBox reponse1 = (CheckBox) findViewById(R.id.buttonRoll);
        final CheckBox reponse2 = (CheckBox) findViewById(R.id.buttonRoll2);
        final CheckBox reponse3 = (CheckBox) findViewById(R.id.buttonRoll3);
        final CheckBox reponse4 = (CheckBox) findViewById(R.id.buttonRoll4);
        final CheckBox reponse5 = (CheckBox) findViewById(R.id.buttonRoll5);
        final CheckBox reponse6 = (CheckBox) findViewById(R.id.buttonRoll6);
        //CheckBox[] checkBoxes = {reponse1,reponse2,reponse3,reponse4};
        final Button next = (Button) findViewById(R.id.buttonNext);

        if(themechoisi.equals("Thème n°1:"))
        {
            GroupQuestion.clearCheck();
           // checkBoxes = new CheckBox[]{reponse1, reponse2,reponse3,reponse4};

            questionTitle1.setText(quizz_theme1.get(questionactuelle).getQuestionTitle1());
            questionNumber.setText(quizz_theme1.get(questionactuelle).getQuestionNumber());
            reponse1.setText(quizz_theme1.get(questionactuelle).getAnswer1());
            reponse2.setText(quizz_theme1.get(questionactuelle).getAnswer2());


            if(quizz_theme1.get(questionactuelle).getAnswer3() != null)
            {
                reponse3.setVisibility(View.VISIBLE);
                reponse3.setText(quizz_theme1.get(questionactuelle).getAnswer3());
                    if(quizz_theme1.get(questionactuelle).getAnswer4() == null)
                         {
                            // checkBoxes = new CheckBox[]{reponse1, reponse2,reponse3};
                         }
            }
            else{
                reponse3.setVisibility(View.GONE);
               // checkBoxes = new CheckBox[]{reponse1, reponse2,reponse5,reponse6};
                }


            if(quizz_theme1.get(questionactuelle).getAnswer4() != null)
            {
                reponse4.setVisibility(View.VISIBLE);
                 reponse4.setText(quizz_theme1.get(questionactuelle).getAnswer4());
            }
            else {
                reponse4.setVisibility(View.GONE);
               // checkBoxes = new CheckBox[]{reponse1, reponse2,reponse5,reponse6};
                }


            if(quizz_theme1.get(questionactuelle).getQuestionTitle2() != null)
            {questionTitle2.setVisibility(View.VISIBLE);
            questionTitle2.setText(quizz_theme1.get(questionactuelle).getQuestionTitle2());}
            else{questionTitle2.setVisibility(View.INVISIBLE);}

            if(quizz_theme1.get(questionactuelle).getAnswer5() != null)
            { reponse5.setVisibility(View.VISIBLE);
            reponse5.setText(quizz_theme1.get(questionactuelle).getAnswer5());}
            else{reponse5.setVisibility(View.GONE);}

            if(quizz_theme1.get(questionactuelle).getAnswer6() != null)
            {reponse6.setVisibility(View.VISIBLE);
            reponse6.setText(quizz_theme1.get(questionactuelle).getAnswer6());}
            else{reponse6.setVisibility(View.GONE);}

           // ShuffleAnswer(checkBoxes);
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
        View.OnClickListener clickSurReponse4  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse3.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton3 est déclenchée
        View.OnClickListener clickSurReponse5  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse3.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton3 est déclenchée
        View.OnClickListener clickSurReponse6  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse3.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton3 est déclenchée
        //CheckBox[] finalCheckBoxes = checkBoxes;
        View.OnClickListener clickSurNext  = v -> {

           // ShuffleAnswer(finalCheckBoxes);
            questionactuelle++;
            DisplayQuestion();
        };

        //associe au bouton reponse l'action clickSurBouton1
        reponse1.setOnClickListener(clickSurReponse1);
        reponse2.setOnClickListener(clickSurReponse2);
        reponse3.setOnClickListener(clickSurReponse3);
        reponse4.setOnClickListener(clickSurReponse4);
        reponse5.setOnClickListener(clickSurReponse5);
        reponse6.setOnClickListener(clickSurReponse6);

        next.setOnClickListener(clickSurNext);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monquestionnaire);

        quizz_theme1 = new ArrayList<>();

        Question_element question1_theme1 = new Question_element("Question 1", "Je vérifie si une victime respire:", "en vérifiant si son torse se soulève",true,"en lui faisant du bouche à bouche",false,"en écoutant son souffle,en me rapprochant de son visage",true);
        Question_element question2_theme1 = new Question_element("Question 2","A chaque nouveau départ je vérifie:", "qu'il n'y a pas de trace d'huile sous le véhicule",true,"le réglage des suspensions",false,"la propreté des plaques et des feux", true,"qu'aucun pneu n'est dégonflé",true);
        Question_element question3_theme1 = new Question_element("Question 3","Cet usager: -est un véhicule d'intérêt général prioritaire","oui",false,"non",true,"- bénéficie de facilités de passages","oui",true,"non",false);
        Question_element question4_theme1=  new Question_element("Question 4","L'intervalle de sécurité après le véhicule qui nous précède est:","suffisant",true,"faible",false);

        quizz_theme1.add(question1_theme1);
        quizz_theme1.add(question2_theme1);
        quizz_theme1.add(question3_theme1);
        quizz_theme1.add(question4_theme1);

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
