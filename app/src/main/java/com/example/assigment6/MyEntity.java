package com.example.assigment6;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String teksti;
    public String aika;

}