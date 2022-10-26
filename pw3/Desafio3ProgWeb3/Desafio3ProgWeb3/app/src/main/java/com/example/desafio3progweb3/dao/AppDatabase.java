package com.example.desafio3progweb3.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.desafio3progweb3.model.Produto;

@Database(entities = {Produto.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract ProdutoDAO createProdutoDAO();

    public static AppDatabase getInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "produtos_organicos_database").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
