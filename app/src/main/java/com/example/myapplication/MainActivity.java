package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
private DataBaseFirmy dataBaseFirmy;
EditText editTextImie;
EditText editTextNazwisko;
EditText editTextJezyk;
Spinner spinnerStanowisko;
Button buttonDodaj;
List<Pracownik> pracownicy;
ListView listView;
ArrayAdapter<Pracownik> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextImie=findViewById(R.id.editTextTextPersonName);
        editTextNazwisko=findViewById(R.id.editTextTextPersonName2);
        editTextJezyk=findViewById(R.id.editTextTextPersonName4);
        spinnerStanowisko=findViewById(R.id.spinner);
        buttonDodaj=findViewById(R.id.button);
        listView=findViewById(R.id.listView);

        RoomDatabase.Callback mojCallback=new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
                super.onOpen(db);
            }

        };

        dataBaseFirmy= Room.databaseBuilder(
                getApplicationContext(),
                DataBaseFirmy.class,
                "PracownicyDB"
        ).addCallback(mojCallback)
        .allowMainThreadQueries()
        .build();

        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String imie=editTextImie.getText().toString();
                        String nazwisko=editTextNazwisko.getText().toString();
                        String jezykObcy=editTextJezyk.getText().toString();
                        String stanowisko=spinnerStanowisko.getSelectedItem().toString();
                        dataBaseFirmy.getDaoPracownicy().DodajPracownika(new Pracownik(imie, nazwisko, "Polski", jezykObcy, 10000.0, stanowisko));
                        wypiszPracownikow();
                    }
                }
        );
        wypiszPracownikow();
       listView.setOnItemClickListener(
               new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                       dataBaseFirmy.getDaoPracownicy().UsunPracownika(pracownicy.get(i));
                       arrayAdapter.notifyDataSetChanged();

                   }
               }
       );

    }
    private void wypiszPracownikow(){
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executorService.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        pracownicy=dataBaseFirmy.getDaoPracownicy().wypiszWszystkichPracownikow();
                        handler.post(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,pracownicy);
                                        listView.setAdapter(arrayAdapter);
                                    }
                                }
                        );
                    }
                }
        );
    }
    private void DodajDaneDoBazy(Pracownik pracownik){
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Handler handler=new Handler(Looper.getMainLooper());
        executorService.execute(
                new Runnable() {
                    @Override
                    public void run() {

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Dodano do bazy", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
        );
    }
}
