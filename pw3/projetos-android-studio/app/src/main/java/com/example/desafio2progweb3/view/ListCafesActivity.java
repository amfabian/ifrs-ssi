package com.example.desafio2progweb3.view;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.desafio2progweb3.R;
import com.example.desafio2progweb3.adapter.LinhaConsultaAdapter;
import com.example.desafio2progweb3.dao.AppDatabase;
import com.example.desafio2progweb3.dao.CafeDAO;
import com.example.desafio2progweb3.model.Cafe;

import java.util.List;

public class ListCafesActivity extends AppCompatActivity {

    private ListView listCafes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cafes);
        listCafes = this.findViewById(R.id.listViewCafes);
        CafeDAO cafeDAO = AppDatabase.getInstance(getApplicationContext()).createCafeDAO();
        getAll(cafeDAO.getAllCafes());
    }

    private void getAll(List<Cafe> allCafes) {
        listCafes.setAdapter(new LinhaConsultaAdapter(this, allCafes));
    }
}
