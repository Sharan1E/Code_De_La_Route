package com.example.code_de_la_route;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class QuizzActivity extends AppCompatActivity {

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
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources(). getColor(R.color.orange)));

        if (MainActivity.choixmode==1)
        {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.actionbar_theme_choice_activity_quizz);
            MainActivity.choixmode=1;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        else if (MainActivity.choixmode==0)
        {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.actionbar_theme_choice_activity_exam);
            MainActivity.choixmode=0;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        setContentView(R.layout.activity_quizz);


        quizz_theme = new ArrayList<>();
        themechoisi = ThemeChoiceActivity.getThemeChoisi();

       if(themechoisi.equals("Thème n°1:"))
        {
            Question_element question1_theme1 = new Question_element("question1_theme1","Cette balise indique une priorité à droite:", "OUI",false,"NON",true);
            Question_element question2_theme1 = new Question_element("question2_theme1","Je ralentis:", "OUI",true,"NON",false,"Je vérifie que l'usager à droite m'as bien vu:","OUI",true,"NON",false);
            Question_element question3_theme1 = new Question_element("question3_theme1","Je cède le passage à droite:", "OUI",true,"NON",false);
            Question_element question4_theme1 = new Question_element("question4_theme1","Je tourne à droite.Je cède le passage :", "à droite",true,"à gauche",true, "L'arrêt à l'intersection est:","obligatoire",false,"facultatif",true);
            Question_element question5_theme1 = new Question_element("question5_theme1","Pour aborder cette intersection, le véhicule gris doit ralentir:", "OUI",true,"NON",false);
            Question_element question6_theme1 = new Question_element("question6_theme1","Le véhicule qui passe en premier est :", "le véhicule à droite",false,"le véhicule en face",true,"moi",false);
            Question_element question7_theme1 = new Question_element("question7_theme1","Ce panneau indique :", "un danger inconnu",false,"une priorité à  droite",true,"un stop",false);
            Question_element question8_theme1 = new Question_element("question8_theme1"," ", "Je passe",false,"Je suis prioritaire",false,"Je cède le passage à droite",true);
            Question_element question9_theme1 = new Question_element("question9_theme1","A la prochaine intersection, les usagers venant de droite et de gauche, devront me céder le passage :", "OUI",true,"NON",false);
            Question_element question10_theme1 = new Question_element("question10_theme1","Les usagers arrivant des autres routes devront me céder le passage :", "sur plusieurs intersections",true,"à la prochaine intersection uniquement",false);

            quizz_theme.add(question1_theme1);
            quizz_theme.add(question2_theme1);
            quizz_theme.add(question3_theme1);
            quizz_theme.add(question4_theme1);
            quizz_theme.add(question5_theme1);
            quizz_theme.add(question6_theme1);
            quizz_theme.add(question7_theme1);
            quizz_theme.add(question8_theme1);
            quizz_theme.add(question9_theme1);
            quizz_theme.add(question10_theme1);

        }

        if(themechoisi.equals("Thème n°2:"))
        {

            Question_element question1_theme2 = new Question_element("question1_theme2","J'anticipe en mettant le pied devant le frein immédiatement :", "OUI",true,"NON",false,"Je cèderai le passage :","à gauche",true,"à droite",true);
            Question_element question2_theme2 = new Question_element("question2_theme2","Quelle est la situation la plus dangereuse ?", "La situation 1",false,"La situation 2",true);
            Question_element question3_theme2 = new Question_element("question3_theme2"," ", "Je maintiens l'allure",false,"je me place sur lavoie centrale",false,"je ralentis",true,"J'allume les feux de détresse",true);
            Question_element question4_theme2 = new Question_element("question4_theme2","L'adhérence risque d'être réduite :", "OUI",true,"NON",true,"Je roule au maximum de la vitesse autorisée :","OUI",false,"NON",true);
            Question_element question5_theme2 = new Question_element("question5_theme2"," ", "J'accèlère",false,"ou je ralentis",true);
            Question_element question6_theme2 = new Question_element("question6_theme2","L'oubli des clignotants pour indiquer un changement de direction peut être sanctionné par une amende et un retrait de points :", "OUI",true,"NON",false);
            Question_element question7_theme2 = new Question_element("question7_theme2","Pour signaler mon intention d'emprunter l'emplacement à droite :", "je freine fort",false,"j'active les clignotans",true);
            Question_element question8_theme2 = new Question_element("question8_theme2","Pour signaler ma présence à cette intersection : - je klaxonne", "le jour",true,"la nuit",true,"je fais un appel lumineux","le jour",false,"la nuit",true);
            Question_element question9_theme2 = new Question_element("question9_theme2","Je circule à 130 km/h.", "je maintiens l'allure",false,"je ralentis",true,"la distance de sécurité est :","suffisante",false,"insuffisante",false);
            Question_element question10_theme2 = new Question_element("question10_theme2","Pendant le temps de réaction, le véhicule continue d'avancer à la même vitesse :","OUI",true,"NON",false);

            quizz_theme.add(question1_theme2);
            quizz_theme.add(question2_theme2);
            quizz_theme.add(question3_theme2);
            quizz_theme.add(question4_theme2);
            quizz_theme.add(question5_theme2);
            quizz_theme.add(question6_theme2);
            quizz_theme.add(question7_theme2);
            quizz_theme.add(question8_theme2);
            quizz_theme.add(question9_theme2);
            quizz_theme.add(question10_theme2);

        }
        else if(themechoisi.equals("Thème n°3:"))
        {
            Question_element question1_theme3 = new Question_element("question1_theme3","Pour voir loin devant moi, j’utilise :", "les feux de position seuls", false, "les feux de croisement", false, "les feux de route", true, "les feux de brouillard arrière", false);
            Question_element question2_theme3 = new Question_element("question2_theme3", "La visibilité est réduite. J’allume :", "les feux de position seuls", false, "les feux de croisement", true, "Je peux rouler sans feux", false);
            Question_element question3_theme3 = new Question_element("question3_theme3", "Dans cette situation, j’utilise les feux de croisement essentiellement pour :", "voir", false, "ou être vu", true);
            Question_element question4_theme3 = new Question_element("question4_theme3", "La nuit : - le champ visuel est réduit", "oui", true, "non", false, "- la perception de la profondeur augmente", "oui", false, "non", true);
            Question_element question5_theme3 = new Question_element("question5_theme3", "Dans cette situation, j’allume les feux de position : - pour voir", "oui", false, "non", true, "- pour être vu", "oui", true, "non", false);
            Question_element question6_theme3 = new Question_element("question6_theme3", "L’aquaplanage : - c’est quand l’eau", "n’est plus évacuée par le pneu", true, "est évacuée trop brusquement par le pneu", false, "- entraîne", "le blocage des pneus", false, "une perte de contrôle du véhicule", true);
            Question_element question7_theme3 = new Question_element("question7_theme3", "Il pleut fortement. j’allume :", "les feux de position seuls", false, "les feux de croisement", true, "les feux de route", false, "les feux de brouillard avant", true);
            Question_element question8_theme3 = new Question_element("question8_theme3", "Ma visibilité est inférieure à 50m, je roule au maximum à :", "90 km/h", false, "70 km/h", false, "50 km/h", true);
            Question_element question9_theme3 = new Question_element("question9_theme3", "Dans ces conditions : - j’utilise les feux de brouillard", "avant", true, "arrière", true, "- je circule à 50 km/h", "oui", false, "non", true);
            Question_element question10_theme3 = new Question_element("question10_theme3", "J’utilise des chaînes à neige. il est conseillé de ne pas dépasser :", "90 km/h", false, "50 km/h", true);

            quizz_theme.add(question1_theme3);
            quizz_theme.add(question2_theme3);
            quizz_theme.add(question3_theme3);
            quizz_theme.add(question4_theme3);
            quizz_theme.add(question5_theme3);
            quizz_theme.add(question6_theme3);
            quizz_theme.add(question7_theme3);
            quizz_theme.add(question8_theme3);
            quizz_theme.add(question9_theme3);
            quizz_theme.add(question10_theme3);

        }
        else if(themechoisi.equals("Thème n°4:"))
        {
            Question_element question1_theme4 = new Question_element("question1_theme4","Un motard, peut circuler : - sur la voie A", "oui", false, "non", true, "- dans la zone B", "oui", true, "non", false);
            Question_element question2_theme4 = new Question_element("question2_theme4", "Je quitte :", "une aire piétonne", false, "une voie verte", false, "une zone de rencontre", true, "une zone 30", false);
            Question_element question3_theme4 = new Question_element("question3_theme4", "Dans cette zone, les piétons : - peuvent utiliser toute la chaussée", "oui", true, "non", false, "- sont prioritaires sur tous les véhicules, sauf face aux tramways", "oui", true, "non", false);
            Question_element question4_theme4 = new Question_element("question4_theme4", "En empruntant cette voie, je peux croiser", "des cyclistes", true, "des cyclomotoristes", false, "des motocyclistes", false, "des automobilistes", false);
            Question_element question5_theme4 = new Question_element("question5_theme4", "Une aire piétonne est signalée par le panneau", "n°1", false, "n°2", true);
            Question_element question6_theme4 = new Question_element("question6_theme4", "Je suis bien placé", "oui", true, "non", false);
            Question_element question7_theme4 = new Question_element("question7_theme4", "Il est 10h. Je peux circuler dans cette zone :", "si je suis à pied", true, "si j’effectue une livraison", true, "si j’ai un véhicule de plus de 12 t", false);
            Question_element question8_theme4 = new Question_element("question8_theme4", "Toutes les catégories d’usagers peuvent circuler dans la zone signalée par :", "le panneau 1", true, "le panneau 2", false);
            Question_element question9_theme4 = new Question_element("question9_theme4", "Les panneaux bleus concernent la rue à ma gauche. En tournant à gauche, je vais circuler sur une rue :", "à double sens", false, "à sens unique", true, "Je risque de rencontrer", "des cyclistes", true, "des piétons", true);
            Question_element question10_theme4 = new Question_element("question10_theme4", "Ce panneau annonce la fin :", "d’une sortie d’école", false, "d’une aire piétonne", true, "d’un passage pour piétons", false);

            quizz_theme.add(question1_theme4);
            quizz_theme.add(question2_theme4);
            quizz_theme.add(question3_theme4);
            quizz_theme.add(question4_theme4);
            quizz_theme.add(question5_theme4);
            quizz_theme.add(question6_theme4);
            quizz_theme.add(question7_theme4);
            quizz_theme.add(question8_theme4);
            quizz_theme.add(question9_theme4);
            quizz_theme.add(question10_theme4);

        }

        else if(MainActivity.choixmode==0)
        {
            Question_element question1_theme1 = new Question_element("question1_theme1","Cette balise indique une priorité à droite:", "OUI",false,"NON",true);
            Question_element question2_theme1 = new Question_element("question2_theme1","Je ralentis:", "OUI",true,"NON",false,"Je vérifie que l'usager à droite m'as bien vu:","OUI",true,"NON",false);
            Question_element question3_theme1 = new Question_element("question3_theme1","Je cède le passage à droite:", "OUI",true,"NON",false);
            Question_element question4_theme1 = new Question_element("question4_theme1","Je tourne à droite.Je cède le passage :", "à droite",true,"à gauche",true, "L'arrêt à l'intersection est:","obligatoire",false,"facultatif",true);
            Question_element question5_theme1 = new Question_element("question5_theme1","Pour aborder cette intersection, le véhicule gris doit ralentir:", "OUI",true,"NON",false);
            Question_element question6_theme1 = new Question_element("question6_theme1","Le véhicule qui passe en premier est :", "le véhicule à droite",false,"le véhicule en face",true,"moi",false);
            Question_element question7_theme1 = new Question_element("question7_theme1","Ce panneau indique :", "un danger inconnu",false,"une priorité à  droite",true,"un stop",false);
            Question_element question8_theme1 = new Question_element("question8_theme1"," ", "Je passe",false,"Je suis prioritaire",false,"Je cède le passage à droite",true);
            Question_element question9_theme1 = new Question_element("question9_theme1","A la prochaine intersection, les usagers venant de droite et de gauche, devront me céder le passage :", "OUI",true,"NON",false);
            Question_element question10_theme1 = new Question_element("question10_theme1","Les usagers arrivant des autres routes devront me céder le passage :", "sur plusieurs intersections",true,"à la prochaine intersection uniquement",false);

            Question_element question1_theme2 = new Question_element("question1_theme2","J'anticipe en mettant le pied devant le frein immédiatement :", "OUI",true,"NON",false,"Je cèderai le passage :","à gauche",true,"à droite",true);
            Question_element question2_theme2 = new Question_element("question2_theme2","Quelle est la situation la plus dangereuse ?", "La situation 1",false,"La situation 2",true);
            Question_element question3_theme2 = new Question_element("question3_theme2"," ", "Je maintiens l'allure",false,"je me place sur lavoie centrale",false,"je ralentis",true,"J'allume les feux de détresse",true);
            Question_element question4_theme2 = new Question_element("question4_theme2","L'adhérence risque d'être réduite :", "OUI",true,"NON",true,"Je roule au maximum de la vitesse autorisée :","OUI",false,"NON",true);
            Question_element question5_theme2 = new Question_element("question5_theme2"," ", "J'accèlère",false,"ou je ralentis",true);
            Question_element question6_theme2 = new Question_element("question6_theme2","L'oubli des clignotants pour indiquer un changement de direction peut être sanctionné par une amende et un retrait de points :", "OUI",true,"NON",false);
            Question_element question7_theme2 = new Question_element("question7_theme2","Pour signaler mon intention d'emprunter l'emplacement à droite :", "je freine fort",false,"j'active les clignotans",true);
            Question_element question8_theme2 = new Question_element("question8_theme2","Pour signaler ma présence à cette intersection : - je klaxonne", "le jour",true,"la nuit",true,"je fais un appel lumineux","le jour",false,"la nuit",true);
            Question_element question9_theme2 = new Question_element("question9_theme2","Je circule à 130 km/h.", "je maintiens l'allure",false,"je ralentis",true,"la distance de sécurité est :","suffisante",false,"insuffisante",false);
            Question_element question10_theme2 = new Question_element("question10_theme2","Pendant le temps de réaction, le véhicule continue d'avancer à la même vitesse :","OUI",true,"NON",false);

            Question_element question1_theme3 = new Question_element("question1_theme3","Pour voir loin devant moi, j’utilise :", "les feux de position seuls", false, "les feux de croisement", false, "les feux de route", true, "les feux de brouillard arrière", false);
            Question_element question2_theme3 = new Question_element("question2_theme3", "La visibilité est réduite. J’allume :", "les feux de position seuls", false, "les feux de croisement", true, "Je peux rouler sans feux", false);
            Question_element question3_theme3 = new Question_element("question3_theme3", "Dans cette situation, j’utilise les feux de croisement essentiellement pour :", "voir", false, "ou être vu", true);
            Question_element question4_theme3 = new Question_element("question4_theme3", "La nuit : - le champ visuel est réduit", "oui", true, "non", false, "- la perception de la profondeur augmente", "oui", false, "non", true);
            Question_element question5_theme3 = new Question_element("question5_theme3", "Dans cette situation, j’allume les feux de position : - pour voir", "oui", false, "non", true, "- pour être vu", "oui", true, "non", false);
            Question_element question6_theme3 = new Question_element("question6_theme3", "L’aquaplanage : - c’est quand l’eau", "n’est plus évacuée par le pneu", true, "est évacuée trop brusquement par le pneu", false, "- entraîne", "le blocage des pneus", false, "une perte de contrôle du véhicule", true);
            Question_element question7_theme3 = new Question_element("question7_theme3", "Il pleut fortement. j’allume :", "les feux de position seuls", false, "les feux de croisement", true, "les feux de route", false, "les feux de brouillard avant", true);
            Question_element question8_theme3 = new Question_element("question8_theme3", "Ma visibilité est inférieure à 50m, je roule au maximum à :", "90 km/h", false, "70 km/h", false, "50 km/h", true);
            Question_element question9_theme3 = new Question_element("question9_theme3", "Dans ces conditions : - j’utilise les feux de brouillard", "avant", true, "arrière", true, "- je circule à 50 km/h", "oui", false, "non", true);
            Question_element question10_theme3 = new Question_element("question10_theme3", "J’utilise des chaînes à neige. il est conseillé de ne pas dépasser :", "90 km/h", false, "50 km/h", true);

            Question_element question1_theme4 = new Question_element("question1_theme4","Un motard, peut circuler : - sur la voie A", "oui", false, "non", true, "- dans la zone B", "oui", true, "non", false);
            Question_element question2_theme4 = new Question_element("question2_theme4", "Je quitte :", "une aire piétonne", false, "une voie verte", false, "une zone de rencontre", true, "une zone 30", false);
            Question_element question3_theme4 = new Question_element("question3_theme4", "Dans cette zone, les piétons : - peuvent utiliser toute la chaussée", "oui", true, "non", false, "- sont prioritaires sur tous les véhicules, sauf face aux tramways", "oui", true, "non", false);
            Question_element question4_theme4 = new Question_element("question4_theme4", "En empruntant cette voie, je peux croiser", "des cyclistes", true, "des cyclomotoristes", false, "des motocyclistes", false, "des automobilistes", false);
            Question_element question5_theme4 = new Question_element("question5_theme4", "Une aire piétonne est signalée par le panneau", "n°1", false, "n°2", true);
            Question_element question6_theme4 = new Question_element("question6_theme4", "Je suis bien placé", "oui", true, "non", false);
            Question_element question7_theme4 = new Question_element("question7_theme4", "Il est 10h. Je peux circuler dans cette zone :", "si je suis à pied", true, "si j’effectue une livraison", true, "si j’ai un véhicule de plus de 12 t", false);
            Question_element question8_theme4 = new Question_element("question8_theme4", "Toutes les catégories d’usagers peuvent circuler dans la zone signalée par :", "le panneau 1", true, "le panneau 2", false);
            Question_element question9_theme4 = new Question_element("question9_theme4", "Les panneaux bleus concernent la rue à ma gauche. En tournant à gauche, je vais circuler sur une rue :", "à double sens", false, "à sens unique", true, "Je risque de rencontrer", "des cyclistes", true, "des piétons", true);
            Question_element question10_theme4 = new Question_element("question10_theme4", "Ce panneau annonce la fin :", "d’une sortie d’école", false, "d’une aire piétonne", true, "d’un passage pour piétons", false);

            quizz_theme.add(question1_theme1);
            quizz_theme.add(question2_theme1);
            quizz_theme.add(question3_theme1);
            quizz_theme.add(question4_theme1);
            quizz_theme.add(question5_theme1);
            quizz_theme.add(question6_theme1);
            quizz_theme.add(question7_theme1);
            quizz_theme.add(question8_theme1);
            quizz_theme.add(question9_theme1);
            quizz_theme.add(question10_theme1);


            quizz_theme.add(question1_theme2);
            quizz_theme.add(question2_theme2);
            quizz_theme.add(question3_theme2);
            quizz_theme.add(question4_theme2);
            quizz_theme.add(question5_theme2);
            quizz_theme.add(question6_theme2);
            quizz_theme.add(question7_theme2);
            quizz_theme.add(question8_theme2);
            quizz_theme.add(question9_theme2);
            quizz_theme.add(question10_theme2);

            quizz_theme.add(question1_theme3);
            quizz_theme.add(question2_theme3);
            quizz_theme.add(question3_theme3);
            quizz_theme.add(question4_theme3);
            quizz_theme.add(question5_theme3);
            quizz_theme.add(question6_theme3);
            quizz_theme.add(question7_theme3);
            quizz_theme.add(question8_theme3);
            quizz_theme.add(question9_theme3);
            quizz_theme.add(question10_theme3);

            quizz_theme.add(question1_theme4);
            quizz_theme.add(question2_theme4);
            quizz_theme.add(question3_theme4);
            quizz_theme.add(question4_theme4);
            quizz_theme.add(question5_theme4);
            quizz_theme.add(question6_theme4);
            quizz_theme.add(question7_theme4);
            quizz_theme.add(question8_theme4);
            quizz_theme.add(question9_theme4);
            quizz_theme.add(question10_theme4);

        }
        ShuffleQuizzQuestion(quizz_theme);
        DisplayQuestion();
    }

    public void ShuffleQuizzQuestion(List<Question_element> quizz)
    {
        Random r = new Random();
        for (int i = quizz.size()-1; i >0 ; i--) {

            int j = r.nextInt(i);

            Question_element savequestion = quizz.get(i);
            quizz.set(i, quizz.get(j));
            quizz.set(j,savequestion);
        }
    }

    public void DisplayQuestion()
    {

        final TextView questionTitle1 = findViewById(R.id.questionTitle1);
        final TextView questionTitle2 = findViewById(R.id.questionTitle2);
        final TextView questionNumber = findViewById(R.id.questionNumber);
        final ImageView questionImage = findViewById(R.id.imageQuizz);

        final CheckBox reponse1 = findViewById(R.id.buttonRoll);
        final CheckBox reponse2 = findViewById(R.id.buttonRoll2);
        final CheckBox reponse3 = findViewById(R.id.buttonRoll3);
        final CheckBox reponse4 = findViewById(R.id.buttonRoll4);
        final CheckBox reponse5 = findViewById(R.id.buttonRoll5);
        final CheckBox reponse6 = findViewById(R.id.buttonRoll6);
        CheckBox[] checkBoxes = {reponse1,reponse2,reponse3,reponse4,reponse5,reponse6};
        final Button next = findViewById(R.id.buttonNext);

        if(MainActivity.choixmode==0){next.setVisibility(View.GONE);}

            int imageId = getResources().getIdentifier(quizz_theme.get(questionactuelle).getQuestionImage(), "drawable", getPackageName());
            questionImage.setImageResource(imageId);

            questionTitle1.setText(quizz_theme.get(questionactuelle).getQuestionTitle1());
            int numero = questionactuelle+1;
            String QuestionNumber = "Question "+numero;
            questionNumber.setText(QuestionNumber);
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
                    Intent intent = new Intent(QuizzActivity.this, ScoreActivity.class);
                    intent.putExtra(numberofcorrectanswer, String.valueOf(GoodAnswer));
                    intent.putExtra(numberofanswer,String.valueOf(quizz_theme.size()));
                    startActivity(intent);
                }

        };

        next.setOnClickListener(clickSurNext);

        mProgressBar=(ProgressBar)findViewById(R.id.progressbar);

        if (MainActivity.choixmode==1){mProgressBar.setVisibility(View.GONE);}
        else{
            ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
            animation.setDuration(30000);
            animation.setInterpolator(new DecelerateInterpolator());
            animation.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {}

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

                        Intent intent = new Intent(QuizzActivity.this, ScoreActivity.class);
                        intent.putExtra(numberofcorrectanswer, String.valueOf(GoodAnswer));
                        intent.putExtra(numberofanswer,String.valueOf(quizz_theme.size()));
                        startActivity(intent);
                    }
                }

                @Override
                public void onAnimationCancel(Animator animator) {}

                @Override
                public void onAnimationRepeat(Animator animator) {}
            });
            animation.start();}


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent();
            if (MainActivity.choixmode == 0)
            {
                 intent = new Intent(QuizzActivity.this, MainActivity.class);
            }
            else
                { intent = new Intent(QuizzActivity.this, ThemeChoiceActivity.class);
            }
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
