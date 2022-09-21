package com.example.desafio2progweb3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.desafio2progweb3.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaOpcoes = this.findViewById(R.id.lista);
         String[] itens = {"Cadastrar Café", "Listar Cafés", "Galeria de Fotos", "Onde nos encontrar", "Seja um franqueado"};
         ArrayAdapter<String> arrayItens =
                new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,itens);
         listaOpcoes.setAdapter(arrayItens);
         listaOpcoes.setOnItemClickListener(this);
    }
    @Override
    public void onItemClick(AdapterView<?> listView, View v, int position, long id){
            if(position ==0) {//cadastrar
                Intent intencao = new Intent(this, CadCafeActivity.class);
                startActivity(intencao);
            }
            else if (position == 1) {
                Intent intencao = new Intent(this, ListCafesActivity.class);
                startActivity(intencao);
            } else if (position == 2) {
                Intent intencao = new Intent(this, GaleriaActivity.class);
                startActivity(intencao);
            } else if (position == 3) {
                Uri gmmIntentUri = Uri.parse("geo:-30.0251223,-51.1624198");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }    else if (position == 4) {
                    String url = "https://franquia.cafeculturabrasil.com/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
            }

    }
}