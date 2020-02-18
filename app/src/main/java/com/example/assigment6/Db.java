package com.example.assigment6;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {MyEntity.class}, version = 1)
public abstract class Db extends RoomDatabase {
    public static final String nimi = "DATABASE";
    public abstract TableDao myTableDao();
}