package com.example.questionsenccejaphone.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.questionsenccejaphone.R;
import com.example.questionsenccejaphone.view.SimularProva;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listaOpcoes = this.findViewById(R.id.list);
        String [] itens = {"Simular Prova", "Escolher Área", "Questões Aleatórias", "Verificar Desempenho", "Inserir Questoes"};
        ArrayAdapter<String> arrayItens =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        listaOpcoes.setAdapter(arrayItens);
        listaOpcoes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> listView, View v, int position, long id){
        switch (position) {
            case 0:
                Intent intencao = new Intent(this, SimularProva.class);
                startActivity(intencao);
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Item 2 - Escolher Área clicado", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Item 3 - Questões Aleatórias clicado", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "Item 4 - Verificar Desempenho clicado", Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(getApplicationContext(), "Item 5 - Inserir Questoes clicado", Toast.LENGTH_LONG).show();
                break;
        }
    }
}