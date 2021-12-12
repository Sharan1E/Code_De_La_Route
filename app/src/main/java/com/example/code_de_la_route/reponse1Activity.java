package com.example.code_de_la_route;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.widget.TextView;

public class reponse1Activity extends AppCompatActivity {

    //VILLE est la clé qui sert à récuperer la variable passée par l'autre activité
    //il faut donc que le nom soit le meme que dans l'activite parente
    final String VILLE = "ville";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //On charge l'activité des resultats
        setContentView(R.layout.activity_resultats);

        //On recupere la valeur de la ville qu'on a choisie
        //pour cela il faut passer par l'objet Intent qui a servi a lancer cette activité
        Intent intent = getIntent();
        String villeChoisie = intent.getStringExtra(VILLE);

        //On va afficher du texte en fonction de la ville choisie
        String resultat = "Mauvaise réponse !";
        if(villeChoisie.equalsIgnoreCase("paris")|| villeChoisie.equalsIgnoreCase("mayenne")){
            resultat = "Bonne réponse !";
        }

        //On récupère la vue dans laquelle on va écrire la réponse
        //dans le fichier activity_resultat.xml elle a l'id textResultatQuestion
        TextView vueResultat = (TextView) findViewById(R.id.textResultatQuestion);

        //on écrit le résultat dans le textView de l'affichage de la réponse
        if(vueResultat != null){
            vueResultat.setText(resultat);
        }
    }
}
