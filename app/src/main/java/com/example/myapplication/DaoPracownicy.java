package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DaoPracownicy {
     @Insert
    public void DodajPracownika(Pracownik pracownik);
    @Insert
    public void DodajWieluPracownikow(Pracownik ...pracownicy);
    @Delete
    public void UsunPracownika(Pracownik pracownik);
    @Update
    public void ZaktualizujDanePracownika(Pracownik pracownik);
    @Query("Select * from pracownicy")
    public List<Pracownik>wypiszWszystkichPracownikow();
    @Query("Select * from pracownicy where jezykOjczysty='polski'")
     public List<Pracownik>wypiszPracownikowPolskoJezycznych();
     @Query("Select*from pracownicy where jezykObcy=:jezyk")
     public List<Pracownik> wypiszPracownikowMowiacychJezykiem(String jezyk);
}
