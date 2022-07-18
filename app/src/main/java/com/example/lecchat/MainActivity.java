package com.example.lecchat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lecchat.Adaptadores.DatosListViewAdapter;
import com.example.lecchat.ProcesosG.DataForLst;

public class MainActivity extends AppCompatActivity {

    ListView lst;
    DataForLst dataforlst = new DataForLst();
    DatosListViewAdapter adapter;
    int countforObject = 0, sizeofObject = 0; // count = contador de mensajes a renderizar, sizeofdata = total de objetos que trae la consulta, comprueba que no explote si no se puede realizar la consulta

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeofObject = dataforlst.ConsultarDatos(getApplicationContext());

        if(sizeofObject<1) {
            Toast.makeText(this, "No se encontraron mensajes de la leccion", Toast.LENGTH_LONG).show();
        }
        else {
            adapter = new DatosListViewAdapter(getApplicationContext(),dataforlst.datos(countforObject));

            lst = (ListView)findViewById(R.id.lstChats);
            AttachEvents();
            ActualizarDatoslst();
        }
    }

    public void ActualizarDatoslst() {

        lst.setAdapter(adapter);
    }

    private void AttachEvents(){
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String Audio =  ((TextView)view.findViewById(R.id.lblaudio)).getText().toString();
                dataforlst.playMp3(Audio);
            }
        });
    }

    public void IrAlInicio(View v) {
        startActivity(new Intent(getApplicationContext(), CrearDatos.class));
    }

    public void AvanzarCuento(View v) {

        if(countforObject + 1 < sizeofObject) {
            countforObject = countforObject + 1;
            dataforlst.datos(countforObject);
            ActualizarDatoslst();
        }
        else {
            Toast.makeText(this, "Se ha terminado la lección", Toast.LENGTH_LONG).show();
        }

    }
}