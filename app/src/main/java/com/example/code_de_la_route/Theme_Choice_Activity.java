package com.example.code_de_la_route;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Theme_Choice_Activity extends AppCompatActivity {

    private static String themechoisi;

    public static String getThemeChoisi(){return themechoisi;}
    public void setThemeChoisi(String themechoisi){this.themechoisi = themechoisi;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources(). getColor(R.color.orange)));

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_theme_choice_activity_title_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_theme_choice);


        List <Listview_element> image_details = getListData();
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener((a, v, position, id) -> {
            Object o = listView.getItemAtPosition(position);
            Listview_element element = (Listview_element) o;
            if (element.getThemeNumber().equals("Thème n°1:"))
            {
                Intent intent = new Intent(Theme_Choice_Activity.this, mainQuestionnaireActivity
                        .class);
                intent.putExtra("FROM_ACTIVITY","Entrainement");
                setThemeChoisi(element.getThemeNumber());
                startActivity(intent);
            }
        });
    }

    private  List<Listview_element> getListData() {
        List<Listview_element> list = new ArrayList<>();
        Listview_element theme1 = new Listview_element("Thème n°1:", "La circulation routière", "theme1_circulation_routiere");
        Listview_element theme2 = new Listview_element("Thème n°2:"," Le conducteur", "theme2_conducteur");
        Listview_element theme3 = new Listview_element("Thème n°3:"," La route", "theme3_route");
        Listview_element theme4 = new Listview_element("Thème n°4:"," Les autres usagers", "theme4_autres_usagers");
        Listview_element theme5 = new Listview_element("Thème n°5:"," Les notions diverses", "theme5_notions_diverses");
        Listview_element theme6 = new Listview_element("Thème n°6:"," Les premiers secours", "theme6_premiers_secours");
        Listview_element theme7 = new Listview_element("Thème n°7:"," Prendre et quitter son véhicule", "theme7_prendre_quitter_vehicule");
        Listview_element theme8 = new Listview_element("Thème n°8:"," La mécanique et les équipements", "theme8_mecanique_equipement");
        Listview_element theme9 = new Listview_element("Thème n°9:"," La sécurité du passager et du véhicule", "theme9_securite_passager_vehicule");
        Listview_element theme10 = new Listview_element("Thème n°10:"," L'environnement", "theme10_environnement");


        list.add(theme1);
        list.add(theme2);
        list.add(theme3);
        list.add(theme4);
        list.add(theme5);
        list.add(theme6);
        list.add(theme7);
        list.add(theme8);
        list.add(theme9);
        list.add(theme10);

        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(Theme_Choice_Activity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}