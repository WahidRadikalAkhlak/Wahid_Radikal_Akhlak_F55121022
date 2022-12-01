package com.Wahid_Radikal_Akhlak_F55121022.aplikasi_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataName;
    private String[] datadescription;
    private TypedArray dataPhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> heroes;

    private String [] dataname = {"Wahid", "Fajrin", "Hairul", "Syarif", "Ryhan", "Zukruf", "Edward", "Fauzy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new HeroAdapter(this);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, heroes.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int Position, long id) {
                if (Position==0){
                    startActivity(new Intent(MainActivity.this, wahid.class));
                }
                else if (Position==1){
                    startActivity(new Intent(MainActivity.this, fajrin.class));
                }
                else if (Position==2){
                    startActivity(new Intent(MainActivity.this, Hairul.class));
                }
                else if (Position==3){
                    startActivity(new Intent(MainActivity.this, Syarif.class));
                }
                else if (Position==4){
                    startActivity(new Intent(MainActivity.this, ryhan.class));
                }
                else if (Position==5){
                    startActivity(new Intent(MainActivity.this, zukhruf.class));
                }
                else if (Position==6){
                    startActivity(new Intent(MainActivity.this, edward.class));
                }
                else if (Position==7){
                    startActivity(new Intent(MainActivity.this, fauzy.class));
                }
            }
        });
    }
    private void prepare() {
        dataName =   getResources().getStringArray(R.array.data_name);
        datadescription =    getResources().getStringArray(R.array.data_description);
        dataPhoto =   getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i   = 0; i < dataName.length; i++) {
            Hero hero = new Hero ();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(datadescription[i]);
            heroes.add(hero);
        }
        adapter.setHeroes(heroes);
    }
}