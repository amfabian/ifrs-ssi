package br.edu.ifrs.aplicativocomponentes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

public class SpinnerActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    private TextView textSelecionado;
    String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        valor = getString(R.string.txtSelecionado);

        textSelecionado = findViewById(R.id.textViewValorSelecionado);
        AppCompatSpinner spinner = findViewById(R.id.spinnerExemplo);
        spinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        textSelecionado.setText(valor + " spinner: " + adapterView.getSelectedItem().toString());
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}