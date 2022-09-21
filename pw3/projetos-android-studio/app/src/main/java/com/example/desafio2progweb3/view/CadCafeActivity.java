package com.example.desafio2progweb3.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.SwitchCompat;

import com.example.desafio2progweb3.R;
import com.example.desafio2progweb3.dao.AppDatabase;
import com.example.desafio2progweb3.model.Cafe;
import com.google.android.material.snackbar.Snackbar;

public class CadCafeActivity extends AppCompatActivity {
    AppCompatEditText nome;
    AppCompatEditText descricao;
    AppCompatEditText contemLactose;
    AppCompatEditText ingredientes;
    AppCompatEditText preco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_cafe);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nome = findViewById(R.id.editTextNomeCafe);
                descricao = findViewById(R.id.editTextDescricao);
                contemLactose = findViewById(R.id.editTextDescricao);
                ingredientes = findViewById(R.id.editTextIngredientes);
                preco = findViewById(R.id.editTextPreco);
                Cafe cafe = new Cafe();
                cafe.setNome(nome.getText().toString());
                cafe.setDescricao(descricao.getText().toString());

                SwitchCompat toggle = findViewById(R.id.toggleSimNao);
                toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) { //valor verdadeiro
                            Snackbar.make(findViewById(android.R.id.content), "SIM (Contém Lactose) Selecionado!", Snackbar.LENGTH_SHORT).show();
                            cafe.setContemLactose(true);
                        } else { //valor falso
                            Snackbar.make(findViewById(android.R.id.content), "NÃO (Não Contém Lactose) Selecionado!", Snackbar.LENGTH_SHORT).show();
                            cafe.setContemLactose(false);
                        }
                    }
                });



                cafe.setIngredientes(ingredientes.getText().toString());
                cafe.setPreco(preco.getText().toString());
                AppDatabase.getInstance(getApplicationContext()).createCafeDAO().insert(cafe);
                Toast.makeText(getApplicationContext(), "Café cadastrado com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void limparCampos(){
        nome = findViewById(R.id.editTextNomeCafe);
        descricao = findViewById(R.id.editTextDescricao);
        contemLactose = findViewById(R.id.editTextDescricao);
        ingredientes = findViewById(R.id.editTextIngredientes);
        preco = findViewById(R.id.editTextPreco);
        nome.setText("");
        descricao.setText("");
        contemLactose.setText("");
        ingredientes.setText("");
        preco.setText("");
    }
}
