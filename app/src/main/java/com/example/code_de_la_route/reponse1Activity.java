package com.example.code_de_la_route;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class reponse1Activity extends AppCompatActivity {

    //VILLE est la clé qui sert à récuperer la variable passée par l'autre activité
    //il faut donc que le nom soit le meme que dans l'activite parente
    final String numberofcorrectanswer = "nombredebonnereponse";
    final String numberofanswer = "nombredereponse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultats);

        Button finishbutton = findViewById(R.id.finishbutton);
        final ImageView questionImage = findViewById(R.id.imageScore);
        int imageWinId = getResources().getIdentifier("winning_case", "drawable", getPackageName());
        int imageLoseId = getResources().getIdentifier("losing_case", "drawable", getPackageName());

        Intent intent = getIntent();
        String previousActivity= intent.getStringExtra("FROM_ACTIVITY");


        String numberofgoodanswer = intent.getStringExtra(numberofcorrectanswer);
        String allanswer = intent.getStringExtra(numberofanswer);
        String sansfaute ="Impressionnant, c’est un sans-faute !";
        String codemaitrise = "Bravo, vous maîtrisez votre code de la route !";
        String maitirisetheme = "Bravo, vous maîtrisez ce thème!";
        String presque = "Vous s'y êtes presque !";
        String entrainement = "Entraînez-vous pour faire 5 fautes ou moins.";
        String entrainement2 = "Entraînez-vous pour faire 3 fautes ou moins.";


        int numberofincorrectanswer = Integer.parseInt(allanswer) - Integer.parseInt(numberofgoodanswer);

        TextView vueResultat = findViewById(R.id.textResultatQuestion);
        TextView descriptionResultat = findViewById(R.id.description_score);


        if(MainActivity.choixmode==0)

        {
            if(numberofincorrectanswer==0 )
            {
                questionImage.setImageResource(imageWinId);
                descriptionResultat.setText(sansfaute);
            }
            else if(numberofincorrectanswer<=5)
            {
                questionImage.setImageResource(imageWinId);
                descriptionResultat.setText(codemaitrise);
            }
            else if(numberofincorrectanswer>6 && numberofincorrectanswer<10)
            {
                questionImage.setImageResource(imageLoseId);
                descriptionResultat.setText(presque);
            }
            else
            {
                questionImage.setImageResource(imageLoseId);
                descriptionResultat.setText(entrainement);
            }
        }

        else if(MainActivity.choixmode==1)
        {
            if(numberofincorrectanswer==0)
            {
                questionImage.setImageResource(imageWinId);
                descriptionResultat.setText(sansfaute);
            }
            else if (numberofincorrectanswer<=3)
            {
                questionImage.setImageResource(imageWinId);
                descriptionResultat.setText(maitirisetheme);
            }
            else
                {
                questionImage.setImageResource(imageLoseId);
                descriptionResultat.setText(entrainement2);
                }
        }


        String score = ""+numberofincorrectanswer+" fautes sur "+allanswer;

        //on écrit le résultat dans le textView de l'affichage de la réponse
        if(vueResultat != null){
            vueResultat.setText(score);
        }

        View.OnClickListener clickSurFinish  = v ->
        {
            Intent mintent = new Intent(reponse1Activity.this, MainActivity.class);
            startActivity(mintent);
        };

        finishbutton.setOnClickListener(clickSurFinish);

    }



}
