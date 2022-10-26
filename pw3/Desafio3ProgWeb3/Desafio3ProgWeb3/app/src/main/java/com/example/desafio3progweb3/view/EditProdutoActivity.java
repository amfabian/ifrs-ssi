package com.example.desafio3progweb3.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.desafio3progweb3.R;
import com.example.desafio3progweb3.dao.AppDatabase;
import com.example.desafio3progweb3.dao.ProdutoDAO;
import com.example.desafio3progweb3.model.Produto;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EditProdutoActivity extends AppCompatActivity {

    private TextInputLayout layoutNomeEdit;
    private TextInputEditText txtNomeEdit;
    private TextInputLayout  layoutDescricaoEdit;
    private TextInputEditText txtDescricaoEdit;
    private TextInputLayout layoutQuantidadeEdit;
    private TextInputEditText txtQuantidadeEdit;
    private TextInputLayout layoutPrecoEdit;
    private TextInputEditText txtPrecoEdit;
    AppCompatButton botaoEditar;
    Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_produto);

        layoutNomeEdit = findViewById(R.id.layoutNomeEdit);
        txtNomeEdit = findViewById(R.id.txtNomeEdit);
        layoutDescricaoEdit = findViewById(R.id.layoutDescricaoEdit);
        txtDescricaoEdit = findViewById(R.id.txtDescricaoEdit);
        layoutQuantidadeEdit = findViewById(R.id.layoutQuantidadeEdit);
        txtQuantidadeEdit = findViewById(R.id.txtQuantidadeEdit);
        layoutPrecoEdit = findViewById(R.id.layoutPrecoEdit);
        txtPrecoEdit = findViewById(R.id.txtPrecoEdit);

        botaoEditar =  this.findViewById(R.id.buttonEditar);

        //cria evento para o botão editar
        botaoEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                alterarProduto();
            }
        });
        //Pega o objeto que foi passado como parâmetro

        produto = (Produto) getIntent().getSerializableExtra("produto");
        txtNomeEdit.setText(produto.getNome());
        txtDescricaoEdit.setText(produto.getDescricao());
        txtQuantidadeEdit.setText(produto.getQuantidade());
        txtPrecoEdit.setText(produto.getPreco());
    }

    private void alterarProduto(){

        if(validarCampos()) {

            //modifica os dados do objeto que foi passado como parâmetro
            produto.setNome(txtNomeEdit.getText().toString().trim());
            produto.setDescricao(txtDescricaoEdit.getText().toString().trim());
            produto.setQuantidade(txtQuantidadeEdit.getText().toString().trim());
            produto.setPreco(txtPrecoEdit.getText().toString().trim());
            ProdutoDAO produtoDAO = AppDatabase.getInstance(getApplicationContext()).createProdutoDAO();
            produtoDAO.update(produto);
            mostraMensagem();
        }

    }

    private boolean validarCampos() {
        if(txtNomeEdit.getText().toString().isEmpty()){
            layoutNomeEdit.setErrorEnabled(true);
            layoutNomeEdit.setError("Informe o nome do Produto");
            return false;
        }else{
            layoutNomeEdit.setErrorEnabled(false);
        }
        if(txtDescricaoEdit.getText().toString().isEmpty()){
            layoutDescricaoEdit.setErrorEnabled(true);
            layoutDescricaoEdit.setError("Informe a descricao do Produto");
            return false;
        }else{
            layoutDescricaoEdit.setErrorEnabled(false);
        }
        if(txtQuantidadeEdit.getText().toString().isEmpty()){
            layoutQuantidadeEdit.setErrorEnabled(true);
            layoutQuantidadeEdit.setError("Informe a quantidade do Produto");
            return false;
        }else{
            layoutQuantidadeEdit.setErrorEnabled(false);
        }
        if(txtPrecoEdit.getText().toString().isEmpty()){
            layoutPrecoEdit.setErrorEnabled(true);
            layoutPrecoEdit.setError("Informe o preco do Produto");
            return false;
        }else{
            layoutQuantidadeEdit.setErrorEnabled(false);
        }

        return true;
    }

    private void mostraMensagem() {
        String msg = "Produto Alterado com sucesso! ";

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(msg);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alertDialog.show();
    }
}

