package com.example.code_de_la_route;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class mainQuestionnaireActivity extends AppCompatActivity {

    int GoodAnswer = 0;
    //VILLE est une clé qui sert à transmettre la valeur selectionnée
    final String numberofcorrectanswer = "nombredebonnereponse";
    final String numberofanswer = "nombredereponse";
    String themechoisi = "theme";
    String getpreviousActivity = "ancienne activite";
    int questionactuelle = 0;
    List<Question_element> quizz_theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String previousActivity= intent.getStringExtra("FROM_ACTIVITY");
        getpreviousActivity = previousActivity;
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources(). getColor(R.color.orange)));

        if (previousActivity.equals("Entrainement"))
        {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.actionbar_theme_choice_activity_quizz);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        else if (previousActivity.equals("Examen Blanc"))
        {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.actionbar_theme_choice_activity_exam);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setContentView(R.layout.activity_monquestionnaire);


        quizz_theme = new ArrayList<>();
        themechoisi = Theme_Choice_Activity.getThemeChoisi();

       // if(themechoisi.equals("Thème n°1:"))
        //{
            Question_element question1_theme1 = new Question_element("Question 1", "question1_theme1","Je vérifie si une victime respire:", "en vérifiant si son torse se soulève",true,"en lui faisant du bouche à bouche",false,"en écoutant son souffle,en me rapprochant de son visage",true);
            Question_element question2_theme1 = new Question_element("Question 2","question2_theme1","A chaque nouveau départ je vérifie:", "qu'il n'y a pas de trace d'huile sous le véhicule",true,"le réglage des suspensions",false,"la propreté des plaques et des feux", true,"qu'aucun pneu n'est dégonflé",true);
            Question_element question3_theme1 = new Question_element("Question 3","question3_theme1","Cet usager: -est un véhicule d'intérêt général prioritaire","oui",false,"non",true,"- bénéficie de facilités de passages","oui",true,"non",false);
            Question_element question4_theme1=  new Question_element("Question 4","question4_theme1","L'intervalle de sécurité après le véhicule qui nous précède est:","suffisant",true,"faible",false);

            quizz_theme.add(question1_theme1);
            quizz_theme.add(question2_theme1);
            quizz_theme.add(question3_theme1);
            quizz_theme.add(question4_theme1);

        //}

        DisplayQuestion();

    }

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

        final TextView questionTitle1 = findViewById(R.id.questionTitle1);
        final TextView questionTitle2 = findViewById(R.id.questionTitle2);
        final TextView questionNumber = findViewById(R.id.questionNumber);
        final RadioGroup GroupQuestion = findViewById(R.id.GroupQuestion);
        final ImageView questionImage = findViewById(R.id.imageQuizz);

        final CheckBox reponse1 = findViewById(R.id.buttonRoll);
        final CheckBox reponse2 = findViewById(R.id.buttonRoll2);
        final CheckBox reponse3 = findViewById(R.id.buttonRoll3);
        final CheckBox reponse4 = findViewById(R.id.buttonRoll4);
        final CheckBox reponse5 = findViewById(R.id.buttonRoll5);
        final CheckBox reponse6 = findViewById(R.id.buttonRoll6);
        CheckBox[] checkBoxes = {reponse1,reponse2,reponse3,reponse4,reponse5,reponse6};
        final Button next = findViewById(R.id.buttonNext);

        if(getpreviousActivity.equals("Examen Blanc")){next.setVisibility(View.GONE);}

            int imageId = getResources().getIdentifier(quizz_theme.get(questionactuelle).getQuestionImage(), "drawable", getPackageName());
            questionImage.setImageResource(imageId);

            questionTitle1.setText(quizz_theme.get(questionactuelle).getQuestionTitle1());
            questionNumber.setText(quizz_theme.get(questionactuelle).getQuestionNumber());
            reponse1.setText(quizz_theme.get(questionactuelle).getAnswer1());
            reponse2.setText(quizz_theme.get(questionactuelle).getAnswer2());


            if(quizz_theme.get(questionactuelle).getAnswer3() != null)
            {reponse3.setVisibility(View.VISIBLE);
                reponse3.setText(quizz_theme.get(questionactuelle).getAnswer3());
            } else{ reponse3.setVisibility(View.GONE); }


            if(quizz_theme.get(questionactuelle).getAnswer4() != null)
            { reponse4.setVisibility(View.VISIBLE);
                 reponse4.setText(quizz_theme.get(questionactuelle).getAnswer4()); }
            else { reponse4.setVisibility(View.GONE);}


            if(quizz_theme.get(questionactuelle).getQuestionTitle2() != null)
            {questionTitle2.setVisibility(View.VISIBLE);
            questionTitle2.setText(quizz_theme.get(questionactuelle).getQuestionTitle2());}
            else{questionTitle2.setVisibility(View.INVISIBLE);}

            if(quizz_theme.get(questionactuelle).getAnswer5() != null)
            { reponse5.setVisibility(View.VISIBLE);
            reponse5.setText(quizz_theme.get(questionactuelle).getAnswer5());}
            else{reponse5.setVisibility(View.GONE);}

            if(quizz_theme.get(questionactuelle).getAnswer6() != null)
            {reponse6.setVisibility(View.VISIBLE);
            reponse6.setText(quizz_theme.get(questionactuelle).getAnswer6());}
            else{reponse6.setVisibility(View.GONE);}


        final boolean[] uservalue1 = {false};
        final boolean[] uservalue2 = {false};
        final boolean[] uservalue3 = {false};
        final boolean[] uservalue4 = {false};
        final boolean[] uservalue5 = {false};
        final boolean[] uservalue6 = {false};

        boolean answervalue1 = quizz_theme.get(questionactuelle).isAnswer1Correct();
        boolean answervalue2 = quizz_theme.get(questionactuelle).isAnswer2Correct();
        boolean answervalue3 = quizz_theme.get(questionactuelle).isAnswer3Correct();
        boolean answervalue4 = quizz_theme.get(questionactuelle).isAnswer4Correct();
        boolean answervalue5 = quizz_theme.get(questionactuelle).isAnswer5Correct();
        boolean answervalue6 = quizz_theme.get(questionactuelle).isAnswer6Correct();

        boolean[] answervalues = {answervalue1,answervalue2,answervalue3,answervalue4,answervalue5,answervalue6};

        ProgressBar mProgressBar;




        View.OnClickListener clickSurNext  = v -> {
            uservalue1[0] = reponse1.isChecked();
            uservalue2[0] = reponse2.isChecked();
            uservalue3[0] = reponse3.isChecked();
            uservalue4[0] = reponse4.isChecked();
            uservalue5[0] = reponse5.isChecked();
            uservalue6[0] = reponse6.isChecked();

            boolean[] uservalues = {uservalue1[0], uservalue2[0], uservalue3[0], uservalue4[0],
                    uservalue5[0], uservalue6[0]};

            if(Arrays.equals(uservalues, answervalues))
            {
                GoodAnswer++;
            }
            questionactuelle++;

            if (questionactuelle<quizz_theme.size())
            {

                DisplayQuestion();
                for (CheckBox checkBox : checkBoxes) {
                    if (checkBox.isChecked()) {
                        checkBox.setChecked(false);
                        checkBox.setSelected(false);
                    }
                }
            }
            else
                {
                    Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
                    intent.putExtra(numberofcorrectanswer, String.valueOf(GoodAnswer));
                    intent.putExtra(numberofanswer,String.valueOf(quizz_theme.size()));
                    startActivity(intent);
                }

        };

        next.setOnClickListener(clickSurNext);

        mProgressBar=(ProgressBar)findViewById(R.id.progressbar);

        if (getpreviousActivity.equals("Entrainement")){mProgressBar.setVisibility(View.GONE);}
        else{
            ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
            animation.setDuration(30000);
            animation.setInterpolator(new DecelerateInterpolator());
            animation.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) { }

                @Override
                public void onAnimationEnd(Animator animator) {

                    uservalue1[0] = reponse1.isChecked();
                    uservalue2[0] = reponse2.isChecked();
                    uservalue3[0] = reponse3.isChecked();
                    uservalue4[0] = reponse4.isChecked();
                    uservalue5[0] = reponse5.isChecked();
                    uservalue6[0] = reponse6.isChecked();

                    boolean[] uservalues = {uservalue1[0], uservalue2[0], uservalue3[0], uservalue4[0],
                            uservalue5[0], uservalue6[0]};

                    if(Arrays.equals(uservalues, answervalues))
                    {
                        GoodAnswer++;
                    }
                    questionactuelle++;
                    if (questionactuelle<quizz_theme.size())
                    {

                        DisplayQuestion();
                        for (CheckBox checkBox : checkBoxes) {
                            if (checkBox.isChecked()) {
                                checkBox.setChecked(false);
                                checkBox.setSelected(false);
                            }
                        }
                    }
                    else
                    {
                        Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
                        intent.putExtra(numberofcorrectanswer, String.valueOf(GoodAnswer));
                        intent.putExtra(numberofanswer,String.valueOf(quizz_theme.size()));
                        startActivity(intent);
                    }
                }

                @Override
                public void onAnimationCancel(Animator animator) { }

                @Override
                public void onAnimationRepeat(Animator animator) { }
            });
            animation.start();}


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent();
            if (getpreviousActivity.equals("Examen Blanc"))
            {
                 intent = new Intent(mainQuestionnaireActivity.this, MainActivity.class);
            }
            else
                { intent = new Intent(mainQuestionnaireActivity.this, Theme_Choice_Activity.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
