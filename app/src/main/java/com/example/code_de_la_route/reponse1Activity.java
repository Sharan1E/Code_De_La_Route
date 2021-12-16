package com.example.code_de_la_route;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Objects;

public class reponse1Activity extends AppCompatActivity {

    //VILLE est la clé qui sert à récuperer la variable passée par l'autre activité
    //il faut donc que le nom soit le meme que dans l'activite parente
    final String numberofcorrectanswer = "nombredebonnereponse";
    final String numberofanswer = "nombredereponse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources(). getColor(R.color.orange)));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_theme_choice_activity_score);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //On charge l'activité des resultats
        setContentView(R.layout.activity_resultats);

        //On recupere la valeur de la ville qu'on a choisie
        //pour cela il faut passer par l'objet Intent qui a servi a lancer cette activité
        Intent intent = getIntent();
        String numberofgoodanswer = intent.getStringExtra(numberofcorrectanswer);
        String allanswer = intent.getStringExtra(numberofanswer);

        //On va afficher du texte en fonction de la ville choisie


        int numberofincorrectanswer = Integer.parseInt(allanswer) - Integer.parseInt(numberofgoodanswer);

        //On récupère la vue dans laquelle on va écrire la réponse
        //dans le fichier activity_resultat.xml elle a l'id textResultatQuestion
        TextView vueResultat = findViewById(R.id.textResultatQuestion);
        String score = ""+numberofincorrectanswer+" fautes sur "+allanswer;

        //on écrit le résultat dans le textView de l'affichage de la réponse
        if(vueResultat != null){
            vueResultat.setText(score);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {

            Intent intent = new Intent(reponse1Activity.this, Theme_Choice_Activity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
