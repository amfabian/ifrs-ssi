package br.edu.ifrs.aplicativointencoes;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void abrirMapa(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=-30.0264276,-51.2233058(IFRS POA)?z=15"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void abrirSite(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                "http://www.poa.ifrs.edu.br"));
        startActivity(intent);
    }
    public void abrirNavegadorBuscar(View view){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
        intent.putExtra(SearchManager.QUERY, "android studio");
        startActivity(intent);
    }
    public void abrirEnviarEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, "teste@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Teste da intenção");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}