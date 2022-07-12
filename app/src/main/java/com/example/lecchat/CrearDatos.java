package com.example.lecchat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lecchat.BD.ProcesosBD;
import com.example.lecchat.Esquema.Datos;

public class CrearDatos extends AppCompatActivity {

    EditText campo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_datos);

        campo1 = (EditText) findViewById(R.id.txtDato);
    }

    public void SaveData(View v) {

        Datos data = new Datos();
        data.setDatos(campo1.getText().toString());

        ProcesosBD dbProccess = new ProcesosBD (getApplicationContext());

        boolean guardado = dbProccess.SaveDato(data);
        if (guardado){
            Toast.makeText(getApplicationContext(),"Si se guardo",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"No se guardo",Toast.LENGTH_LONG).show();
        }
    }


    public void Pantalla2(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}