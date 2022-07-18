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

    EditText id, leccion_id, persona, dialogo, NombreAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_datos);

        InicializarControles();
    }

    public void InicializarControles() {

        id = (EditText) findViewById(R.id.txtId);
        leccion_id = (EditText) findViewById(R.id.txtLeccionId);
        persona = (EditText) findViewById(R.id.txtPersona);
        dialogo = (EditText) findViewById(R.id.txtDialogo);
        NombreAudio = (EditText) findViewById(R.id.txtAudio);
    }

    public void SaveData(View v) {

        Datos data = new Datos(
                Integer.parseInt(id.getText().toString()),
                Integer.parseInt(leccion_id.getText().toString()),
                Integer.parseInt(persona.getText().toString()),
                dialogo.getText().toString(),
                NombreAudio.getText().toString()
        );

        ProcesosBD dbProccess = new ProcesosBD (getApplicationContext());

        boolean guardado = dbProccess.SaveDato(data);
        if (guardado){
            Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"No guardado",Toast.LENGTH_LONG).show();
        }
    }


    public void Pantalla2(View v) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

}