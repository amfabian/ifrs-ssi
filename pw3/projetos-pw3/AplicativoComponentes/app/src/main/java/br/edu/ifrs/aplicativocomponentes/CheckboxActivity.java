package br.edu.ifrs.aplicativocomponentes;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.google.android.material.snackbar.Snackbar;

public class CheckboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
    }
    public void onCheckBoxClicked(View view){

        boolean checked = ((AppCompatCheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.checkBoxOp1:
                 if(checked)
                      Snackbar.make(findViewById(android.R.id.content), "Opção 1 selecionada!", Snackbar.LENGTH_SHORT).show();
                 break;
            case R.id.checkBoxOp2:
                 if(checked)
                     Snackbar.make(findViewById(android.R.id.content), "Opção 2 selecionada!", Snackbar.LENGTH_SHORT).show();
                 break;
        }
    }
}