package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pracownik.class}, version = 1,exportSchema = false)
public abstract class DataBaseFirmy extends RoomDatabase {
    public abstract DaoPracownicy getDaoPracownicy();
}
