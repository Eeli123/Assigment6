package com.example.assigment6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;
    EditText editText;
    Date Time = Calendar.getInstance().getTime();
    Db tietokanta;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> lista;
    TableDao myTableDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.nappi);
        this.editText = findViewById(R.id.teksti);
        this.listView = findViewById(R.id.listaview);


        lista = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);
        listView.setAdapter(arrayAdapter);

        tietokanta = Room.databaseBuilder(getApplicationContext(), Db.class, Db.nimi).allowMainThreadQueries().build();

        myTableDao = tietokanta.myTableDao();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyEntity myEntity = new MyEntity();
                myEntity.teksti = editText.getText().toString();
                myEntity.aika = Time.toString();
                myTableDao.InsertMyEntity(myEntity);
                List<MyEntity> lista = myTableDao.getAllInDescendingOrder();

                for (MyEntity t : lista){
                    String s = "";
                    s = s + t.teksti + t.aika;
                    arrayAdapter.add(s);
                }

            }
        });




    }
}
