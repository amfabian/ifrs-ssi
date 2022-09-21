package br.edu.ifrs.aplicativocomponentes;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.snackbar.Snackbar;

public class SwitchActivity extends AppCompatActivity {
    String valor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        valor = getString(R.string.txtSelecionado);
        SwitchCompat toggle = findViewById(R.id.toggleSimNao);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //valor verdadeiro
                    Snackbar.make(findViewById(android.R.id.content), "Selecionou SIM (verdadeiro)!", Snackbar.LENGTH_SHORT).show();
                } else { //valor falso
                    Snackbar.make(findViewById(android.R.id.content), "Selecionou NÃO (falso)!", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }
}