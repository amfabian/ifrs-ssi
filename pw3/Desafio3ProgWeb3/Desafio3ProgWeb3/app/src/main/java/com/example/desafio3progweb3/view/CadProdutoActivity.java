package com.example.desafio3progweb3.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafio3progweb3.R;
import com.example.desafio3progweb3.dao.AppDatabase;
import com.example.desafio3progweb3.model.Produto;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CadProdutoActivity extends AppCompatActivity {

    private TextInputLayout layoutNome;
    private TextInputEditText txtNome;
    private TextInputLayout layoutDescricao;
    private TextInputEditText txtDescricao;
    private TextInputLayout layoutQuantidade;
    private TextInputEditText txtQuantidade;
    private TextInputLayout layoutPreco;
    private TextInputEditText txtPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produto);

        layoutNome = findViewById(R.id.layoutNome);
        txtNome = findViewById(R.id.txtNomeCad);
        layoutDescricao = findViewById(R.id.layoutDescricao);
        txtDescricao = findViewById(R.id.txtDescricaoCad);
        layoutQuantidade = findViewById(R.id.layoutQuantidade);
        txtQuantidade = findViewById(R.id.txtQuantidadeCad);
        layoutPreco = findViewById(R.id.layoutPreco);
        txtPreco = findViewById(R.id.txtPrecoCad);


        Button button = findViewById(R.id.buttonCadastrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Produto produto = new Produto();
                produto.setNome(txtNome.getText().toString());
                produto.setDescricao(txtDescricao.getText().toString());
                produto.setQuantidade(txtQuantidade.getText().toString());
                produto.setPreco(txtPreco.getText().toString());
                if(validarCampos()) {
                    AppDatabase.getInstance(getApplicationContext()).createProdutoDAO().insert(produto);
                    Snackbar snackbar = Snackbar
                            .make(findViewById(android.R.id.content), "Produto cadastrado com sucesso", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    voltar();
                }

            }
        });
    }

    private boolean validarCampos() {
        if(txtNome.getText().toString().isEmpty()){
            layoutNome.setErrorEnabled(true);
            layoutNome.setError("Informe o nome do Produto");
            return false;
        }else{
            layoutNome.setErrorEnabled(false);
        }
        if(txtDescricao.getText().toString().isEmpty()){
            layoutDescricao.setErrorEnabled(true);
            layoutDescricao.setError("Informe a descricao do Produto");
            return false;
        }else{
            layoutDescricao.setErrorEnabled(false);
        }
        if(txtQuantidade.getText().toString().isEmpty()){
            layoutQuantidade.setErrorEnabled(true);
            layoutQuantidade.setError("Informe a quantidade do Produto");
            return false;
        }else{
            layoutQuantidade.setErrorEnabled(false);
        }
        if(txtPreco.getText().toString().isEmpty()){
            layoutPreco.setErrorEnabled(true);
            layoutPreco.setError("Informe o preco do Produto");
            return false;
        }else{
            layoutQuantidade.setErrorEnabled(false);
        }

        return true;
    }

    private void voltar() {

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
