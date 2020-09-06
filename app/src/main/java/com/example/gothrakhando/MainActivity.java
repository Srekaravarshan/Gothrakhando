package com.example.gothrakhando;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    ListView lv;
    SearchView sv;
    adapter adapter;
    ArrayList<model> arrayList = new ArrayList<model>();

    Integer[] image = {R.drawable.chevron_right};
    String[] gothram = {"Moudhgalya gothram","Mathanga gothram","Maithreya gothram","Mandavya gothram","Vathsayana gothram","Kousika gothram","Koundinya gothram","Kouthsa gothram","Salika gothram","Vasishta gothram","Sandilya gothram","Gouthama gothram","Jabali gothram","Gargeya gothram","Janhu gothram","Kashyapa gothram","Viswamithra gothram","Bhargava gothram","Parasara gothram","Agasthya gothram","Mareechi gothram","Markandeya gothram","Aangerasa gothram","Aruni gothram","Mounjayana gothram","Kanva gothram","chyavana gothram","Jamadhagni gothram","Vathsa gothram","Vyasa gothram","Vamadeva gothram","Bharadhvaja gothram","Bhakeeratha gothram","Dhadheecha gothram","Upamayu gothram","Sri vathasa gothram","Aathreya gothram","Sounaka gothram","Sarabhanga gothram","Dhurvasa gothram","Kupitha gothram","Salihothra gothram","Sakthi gothram","Mandhabala gothram","Valmeeki gothram","Koumantha gothram","Haritha gothram","Pipala gothram","Avrva gothram","Galava gothram","Sumantha gothram","Idhmavaha gothram","Jaimuni gothram","Vaisampavana gothram","Pailava gothram","Kavasa gothram","Asitha gothram","Devala gothram","Soubari gothram","Pramathi gothram","Udhanga gothram","Vusena gothram","Ushneesha gothram","Medhathithi gothram"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);
        sv = findViewById(R.id.search);
        ArrayList<String> gothram_array = new ArrayList<String>();
        Collections.addAll(gothram_array, gothram);
        Arrays.sort(gothram);




        for(int i=0;i<gothram.length;i++){
            model model = new model(gothram[i],image[0]);
            arrayList.add(model);
        }

        adapter = new adapter(this,arrayList, gothram_array);
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.filter(newText);
                return false;
            }
        });


    }
}
