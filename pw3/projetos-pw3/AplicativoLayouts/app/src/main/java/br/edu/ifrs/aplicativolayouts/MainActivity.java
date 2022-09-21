package br.edu.ifrs.aplicativolayouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

//implementa OnItemClickListener para que cada click na lista seja direcionado para essa atividade

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private ListView listaLayouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //referencia a lista que está na tela do layout
        listaLayouts = findViewById(R.id.listaLayouts);
        //determina que a atividade atual (this) irá tratar os eventos de click na lista
        listaLayouts.setOnItemClickListener(this);
    }

    //método que é chamado quando o usuário clica em um item da lista
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //criamos uma opção para cada item da lista
        if (position == 0) {//ConstraintLayout
            Intent intent = new Intent(this, Constraint_Activity.class);
            startActivity(intent);
        }
        if (position == 1) {//LinearLayout
            Intent intent = new Intent(this, Linear_Activity.class);
            startActivity(intent);
        }
        if (position == 2) { //RelativeLayout
            Intent intent = new Intent(this, Relative_Activity.class);
            startActivity(intent);
        }
        if (position == 3) {//FrameLayout
            Intent intent = new Intent(this, FrameActivity.class);
            startActivity(intent);
        }
        if (position == 4) {//GridLayout
            Intent intent = new Intent(this, GridActivity.class);
            startActivity(intent);
        }
    }
}