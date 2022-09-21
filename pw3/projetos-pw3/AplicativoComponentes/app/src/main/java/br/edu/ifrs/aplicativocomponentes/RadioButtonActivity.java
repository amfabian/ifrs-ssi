package br.edu.ifrs.aplicativocomponentes;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class RadioButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
    }
    public void onRbtnClicked (View view){
        //pega outras informações ...
        RadioGroup grupo = (RadioGroup) findViewById(R.id.grupoRbtn);
        int id = grupo.getCheckedRadioButtonId();
        switch(id){
            case R.id.rbtnOp1:
                Snackbar.make(findViewById(android.R.id.content), "Opção 1 selecionada!", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.rbtnOp2:
                Snackbar.make(findViewById(android.R.id.content), "Opção 2 selecionada!", Snackbar.LENGTH_SHORT).show();
                break;
        }
        //mostra mensagem
    }
}