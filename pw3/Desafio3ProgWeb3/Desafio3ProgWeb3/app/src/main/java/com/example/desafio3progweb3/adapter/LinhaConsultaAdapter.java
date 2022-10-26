package com.example.desafio3progweb3.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.desafio3progweb3.R;
import com.example.desafio3progweb3.dao.AppDatabase;
import com.example.desafio3progweb3.dao.ProdutoDAO;
import com.example.desafio3progweb3.model.Produto;
import com.example.desafio3progweb3.view.EditProdutoActivity;
import com.example.desafio3progweb3.view.HomeActivity;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class LinhaConsultaAdapter extends BaseAdapter {

    //Cria layoutinflater para ligar com a view activity_linha.xml
    private static LayoutInflater layoutInflater = null;
    List<Produto> produtos = new ArrayList<>();

    //Cria objeto do tipo que lista os cafes
    private HomeActivity listarProdutos;

    //constructor que recebe a atividade e a lista de tarefas como parametros que irá retornar do bd
    public LinhaConsultaAdapter(HomeActivity listarProdutos, List<Produto> produtos){
        this.produtos = produtos;
        this.listarProdutos = listarProdutos;
        this.layoutInflater = (LayoutInflater) this.listarProdutos.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }





    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int i) { return i;}

    @Override
    public long getItemId(int i) {return i;}

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //Cria um objeto para acessar o layout activity_linha.xml
        final View viewLinhaLista = layoutInflater.inflate(R.layout.activity_linha, null);

        //vincula os campos do arquivo de layout aos objetos cadastrados
        AppCompatTextView textViewCodigo = viewLinhaLista.findViewById(R.id.textViewCodigo);
        AppCompatTextView textViewNome = viewLinhaLista.findViewById(R.id.textViewNome);
        AppCompatTextView textViewDescricao = viewLinhaLista.findViewById(R.id.textViewDescricao);
        AppCompatTextView textViewPreco = viewLinhaLista.findViewById(R.id.textViewPreco);
        AppCompatTextView textViewQuantidade = viewLinhaLista.findViewById(R.id.textViewQuantidade);
        AppCompatImageButton buttonExcluir = viewLinhaLista.findViewById(R.id.buttonExcluir);
        AppCompatImageButton buttonEditar = viewLinhaLista.findViewById(R.id.buttonEditar);

        textViewCodigo.setText(String.valueOf(produtos.get(position).getId()));

        textViewNome.setText(produtos.get(position).getNome());
        textViewDescricao.setText("Descricao: " +produtos.get(position).getDescricao());
        textViewPreco.setText("Preco: R$ "+produtos.get(position).getPreco());
        textViewQuantidade.setText("Quantidade: "+produtos.get(position).getQuantidade());

        //Criando evento para excluir um registro do BD
        buttonExcluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Snackbar snackbar = Snackbar
                        .make(view, "Produto excluído com sucesso", Snackbar.LENGTH_LONG);
                snackbar.show();
                ProdutoDAO produtoDAO = AppDatabase.getInstance(listarProdutos.getApplicationContext()).createProdutoDAO();
                List<Produto> produtos = produtoDAO.getAllProdutos();
                produtoDAO.delete(produtos.get(position));
                atualizaLista(position);
            }
        });
        //Criando evento para editar um registro do BD
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(listarProdutos, EditProdutoActivity.class);
                intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
                intent.putExtra("produto", produtos.get(position));
                listarProdutos.startActivity(intent);
            }
        });

        return viewLinhaLista;
    }

    private void atualizaLista(int position) {
        this.produtos.remove(position);
        this.notifyDataSetChanged();

    }
}
