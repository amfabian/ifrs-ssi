package com.example.desafio2progweb3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.example.desafio2progweb3.R;
import com.example.desafio2progweb3.dao.AppDatabase;
import com.example.desafio2progweb3.dao.CafeDAO;
import com.example.desafio2progweb3.model.Cafe;
import com.example.desafio2progweb3.view.EditCafeActivity;
import com.example.desafio2progweb3.view.ListCafesActivity;

import java.util.ArrayList;
import java.util.List;

public class LinhaConsultaAdapter extends BaseAdapter {

    //Cria layoutinflater para ligar com a view activity_linha.xml
    private static LayoutInflater layoutInflater = null;
    List<Cafe> cafes = new ArrayList<>();

    //Cria objeto do tipo que lista os cafes
    private ListCafesActivity listarCafes;

    //constructor que recebe a atividade e a lista de tarefas como parametros que irá retornar do bd
    public LinhaConsultaAdapter(ListCafesActivity listarCafes, List<Cafe> cafes){
        this.cafes = cafes;
        this.listarCafes = listarCafes;
        this.layoutInflater = (LayoutInflater) this.listarCafes.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }





    @Override
    public int getCount() {return cafes.size();}

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
        AppCompatTextView textViewContemLactose = viewLinhaLista.findViewById(R.id.textViewContemLactose);
        AppCompatTextView textViewIngredientes = viewLinhaLista.findViewById(R.id.textViewIngredientes);
        AppCompatTextView textViewPreco = viewLinhaLista.findViewById(R.id.textViewPreco);
        AppCompatButton buttonExcluir = viewLinhaLista.findViewById(R.id.buttonExcluir);
        AppCompatButton buttonEditar = viewLinhaLista.findViewById(R.id.buttonEditar);

        textViewCodigo.setText(String.valueOf(cafes.get(position).getId()));
        textViewNome.setText(cafes.get(position).getNome());
        textViewDescricao.setText("Descricao: " +cafes.get(position).getDescricao());
        if (cafes.get(position).isContemLactose()) textViewContemLactose.setText("Contém Lactose");
            else textViewContemLactose.setText("Não contém Lactose");
        textViewIngredientes.setText("Ingredientes: "+cafes.get(position).getIngredientes());
        textViewPreco.setText("Preco: "+cafes.get(position).getPreco());

        //Criando evento para excluir um registro do BD
        buttonExcluir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                CafeDAO cafeDAO = AppDatabase.getInstance(listarCafes.getApplicationContext()).createCafeDAO();
                List<Cafe> cafes = cafeDAO.getAllCafes();
                cafeDAO.delete(cafes.get(position));
                atualizaLista(position);
            }
        });
        //Criando evento para editar um registro do BD
        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(listarCafes, EditCafeActivity.class);
                intent.setFlags((Intent.FLAG_ACTIVITY_CLEAR_TOP));
                intent.putExtra("cafe", cafes.get(position));
                listarCafes.startActivity(intent);
            }
        });

        return viewLinhaLista;
    }

    private void atualizaLista(int position) {
        String mensagem = "Café excluído com sucesso!";
        Toast.makeText(listarCafes, mensagem, Toast.LENGTH_LONG).show();
        this.cafes.remove(position);
        this.notifyDataSetChanged();
    }
}
