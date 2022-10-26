package com.example.desafio3progweb3.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.desafio3progweb3.model.Produto;

import java.util.List;
@Dao
public interface ProdutoDAO {

    @Query("SELECT * FROM Produto")
    public List<Produto> getAllProdutos();

    @Query("SELECT * FROM Produto  WHERE nome =:name")
    public List<Produto> getProdutoByName(String name);

    @Insert(onConflict = REPLACE)
    public void insert(Produto produto);

    @Update
    public void update(Produto produto);

    @Delete
    public void delete(Produto produto);

}
