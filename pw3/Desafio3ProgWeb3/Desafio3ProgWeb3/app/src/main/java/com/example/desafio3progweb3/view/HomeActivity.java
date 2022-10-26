package com.example.desafio3progweb3.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafio3progweb3.R;
import com.example.desafio3progweb3.adapter.LinhaConsultaAdapter;
import com.example.desafio3progweb3.dao.AppDatabase;
import com.example.desafio3progweb3.dao.ProdutoDAO;
import com.example.desafio3progweb3.model.Produto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView listProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
        listProdutos = this.findViewById(R.id.listViewProdutos);
        ProdutoDAO produtoDAO = AppDatabase.getInstance(getApplicationContext()).createProdutoDAO();
        getAll(produtoDAO.getAllProdutos());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cadastrar();
            }

        });





    }

    private void Cadastrar() {
        Intent intent = new Intent(this, CadProdutoActivity.class);
        startActivity(intent);
    }
    private void getAll(List<Produto> allProdutos) {
        listProdutos.setAdapter(new LinhaConsultaAdapter(this, allProdutos));
    }


}
