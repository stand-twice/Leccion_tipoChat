package com.example.lecchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.lecchat.Adaptadores.DatosListViewAdapter;
import com.example.lecchat.BD.ProcesosBD;
import com.example.lecchat.Esquema.Datos;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lst = (ListView)findViewById(R.id.lstChats);

        DatosListViewAdapter adapter = new DatosListViewAdapter(getApplicationContext(),getAllData());
        lst.setAdapter(adapter);
    }

    private List<Datos> getAllData() {
        ProcesosBD obj = new ProcesosBD(getApplicationContext());

        return obj.ObtenerDatos();
    }
}