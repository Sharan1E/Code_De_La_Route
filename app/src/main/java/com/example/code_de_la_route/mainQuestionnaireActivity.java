package com.example.code_de_la_route;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class mainQuestionnaireActivity extends AppCompatActivity {

    //VILLE est une clé qui sert à transmettre la valeur selectionnée
    final String VILLE = "ville";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monquestionnaire);

        final Button reponse1 = (Button) findViewById(R.id.buttonRoll);
        final Button reponse2 = (Button) findViewById(R.id.buttonRoll2);
        final Button reponse3 = (Button) findViewById(R.id.buttonRoll3);

        //on définit ce qu'il va se passer quand l'action clickSurBouton1 est déclenchée
        View.OnClickListener clickSurBouton1  = v -> {
            //quand on clique sur le bouton 1 on passe a l'activite resultat (reponse1Activity)
            // en passant comme parametre le texte du bouton 1
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse1.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton2 est déclenchée
        View.OnClickListener clickSurBouton2  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse2.getText().toString());
            startActivity(intent);
        };

        //on définit ce qu'il va se passer quand l'action clickSurBouton3 est déclenchée
        View.OnClickListener clickSurBouton3  = v -> {
            Intent intent = new Intent(mainQuestionnaireActivity.this, reponse1Activity.class);
            intent.putExtra(VILLE, reponse3.getText().toString());
            startActivity(intent);
        };

        //associe au bouton reponse l'action clickSurBouton1
        reponse1.setOnClickListener(clickSurBouton1);
        reponse2.setOnClickListener(clickSurBouton2);
        reponse3.setOnClickListener(clickSurBouton3);

    }



}
