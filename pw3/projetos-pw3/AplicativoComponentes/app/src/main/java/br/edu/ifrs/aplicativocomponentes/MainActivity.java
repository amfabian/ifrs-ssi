package br.edu.ifrs.aplicativocomponentes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listaComponentes);
        //Pega da classe componente a lista de componentes/itens para mostrar
        Componente[] componentes = Componente.componentes;
        //Adapter e' um padrao de objeto que diz como os itens de uma classe
        // serao exibidos na lista -> chama o metodo toString()
        ArrayAdapter<Componente>  listAdapter = new ArrayAdapter(this,
                android.R.layout.select_dialog_item, componentes);
        lista.setAdapter(listAdapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {//componente Spinner
            Intent intent = new Intent(this, SpinnerActivity.class);
            startActivity(intent);
        }
        if (position == 1) {//componente Toggle
            Intent intent = new Intent(this, ToggleActivity.class);
            startActivity(intent);
        }
        if (position == 2) {//componente Switch
            Intent intent = new Intent(this, SwitchActivity.class);
            startActivity(intent);
        }
        if (position == 3) {//componente Checkbox
            Intent intent = new Intent(this, CheckboxActivity.class);
            startActivity(intent);
        }
        if (position == 4) {//componente RadioButton
            Intent intent = new Intent(this, RadioButtonActivity.class);
            startActivity(intent);
        }
    }
}