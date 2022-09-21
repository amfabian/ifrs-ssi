package com.example.questionsenccejaphone.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.questionsenccejaphone.R;

public class SimularProva extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simular_prova);
        ListView listaOpcoes = this.findViewById(R.id.listAlternativas);
        String [] itens = {"(A) de olhos fechados.", "(B) virando as costas para ele.",
                        "(C) colocado atrás de uma parede", "(D) em uma sala sem luz."};
        ArrayAdapter<String> arrayItens =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itens);
        listaOpcoes.setAdapter(arrayItens);
        listaOpcoes.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> listView, View v, int position, long id){
        switch (position) {
            case 0:
                Toast.makeText(getApplicationContext(), "Alternativa Incorreta", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(getApplicationContext(), "Alternativa Incorreta", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(getApplicationContext(), "Alternativa Incorreta", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(getApplicationContext(), "Alternativa Certa!", Toast.LENGTH_LONG).show();
                break;

        }
    }
}
