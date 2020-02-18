package com.example.assigment6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TableDao {
    @Query("select * from myentity order by id desc")
    List<MyEntity> getAllInDescendingOrder();

    @Insert
    void InsertMyEntity(MyEntity myEntity);



}