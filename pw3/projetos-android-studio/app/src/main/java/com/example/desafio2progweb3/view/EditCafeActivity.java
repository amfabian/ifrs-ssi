package com.example.desafio2progweb3.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.SwitchCompat;

import com.example.desafio2progweb3.R;
import com.example.desafio2progweb3.dao.AppDatabase;
import com.example.desafio2progweb3.dao.CafeDAO;
import com.example.desafio2progweb3.model.Cafe;
import com.google.android.material.snackbar.Snackbar;

public class EditCafeActivity extends AppCompatActivity {

    AppCompatEditText editTextNome;
    AppCompatEditText editTextDesc;
    SwitchCompat toggle;
    AppCompatEditText editTextIngredientes;
    AppCompatEditText editTextPreco;
    AppCompatButton botaoEditar;
    Cafe cafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_cafe);
        editTextNome = this.findViewById(R.id.editTextNomeEdit);
        editTextDesc =  this.findViewById(R.id.editTextDescricaoEdit);
        toggle = this.findViewById(R.id.toggleSimNaoEdit);
        editTextIngredientes = this.findViewById(R.id.editTextIngredientesEdit);
        editTextPreco = this.findViewById(R.id.editTextPrecoEdit);
        botaoEditar =  this.findViewById(R.id.buttonEditar);

        //cria evento para o botão editar
        botaoEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                alterarCafe();
            }
        });
        //Pega o objeto que foi passado como parâmetro
        Bundle extra =  this.getIntent().getExtras();
        cafe = (Cafe) getIntent().getSerializableExtra("cafe");
        editTextNome.setText(cafe.getNome());
        editTextDesc.setText(cafe.getDescricao());
        toggle.setChecked(cafe.isContemLactose());
        editTextIngredientes.setText(cafe.getIngredientes());
        editTextPreco.setText(cafe.getPreco());
        toggle = findViewById(R.id.toggleSimNaoEdit);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { //valor verdadeiro
                    Toast.makeText(getApplicationContext(), "Contém Lactose selecionado", Toast.LENGTH_LONG).show();
                    cafe.setContemLactose(true);
                } else { //valor falso
                    Toast.makeText(getApplicationContext(), "Não Contém Lactose selecionado", Toast.LENGTH_LONG).show();
                    cafe.setContemLactose(false);
                }
            }
        });
    }

    private void alterarCafe(){
        if (editTextNome.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Nome é obrigatório!", Toast.LENGTH_LONG).show();
            editTextNome.requestFocus();
        } else if (editTextDesc.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Descrição é obrigatório!", Toast.LENGTH_LONG).show();
            editTextDesc.requestFocus();
        } else if (editTextIngredientes.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Ingredientes é obrigatório!", Toast.LENGTH_LONG).show();
            editTextIngredientes.requestFocus();
        } else if (editTextPreco.getText().toString().trim().equals("")) {
            Toast.makeText(getApplicationContext(), "Preco é obrigatório!", Toast.LENGTH_LONG).show();
            editTextPreco.requestFocus();
        } else  {
            //modifica os dados do objeto que foi passado como parâmetro
            cafe.setNome(editTextNome.getText().toString().trim());
            cafe.setDescricao(editTextDesc.getText().toString().trim());

            cafe.setIngredientes(editTextIngredientes.getText().toString().trim());
            cafe.setPreco(editTextPreco.getText().toString().trim());
            CafeDAO cafeDAO = AppDatabase.getInstance(getApplicationContext()).createCafeDAO();
            cafeDAO.update(cafe);
            mostraMensagem();
        }

}

    private void mostraMensagem() {
            String msg = "Café Alterado com sucesso! ";

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(msg);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), ListCafesActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alertDialog.show();
    }
}
