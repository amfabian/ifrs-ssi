package com.example.desafio2progweb3.dao;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.desafio2progweb3.model.Cafe;

@Database(entities = {Cafe.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;

    public abstract CafeDAO createCafeDAO();

    public static AppDatabase getInstance(Context context){
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "cafe_database").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
