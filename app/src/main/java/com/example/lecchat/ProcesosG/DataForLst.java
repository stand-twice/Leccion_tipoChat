package com.example.lecchat.ProcesosG;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.lecchat.BD.ProcesosBD;
import com.example.lecchat.Esquema.Datos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.stream.Collectors;

public class DataForLst {

    ArrayList<Datos> Fuente = new ArrayList<>();
    ArrayList<Datos> Arrlst = new ArrayList<>();
    Context context;

    public int ConsultarDatos(Context c) {
        ProcesosBD obj = new ProcesosBD(c);
        context = c;

        Fuente = obj.ObtenerDatos(1);

        return Fuente.size();
    }


    public ArrayList<Datos> datos(int lst_count) {

        Datos datos = new Datos();

            datos.setId(Fuente.get(lst_count).getId());
            datos.setLecciones_id(Fuente.get(lst_count).getLecciones_id());
            datos.setPersona(Fuente.get(lst_count).getPersona());
            datos.setDialogo(Fuente.get(lst_count).getDialogo());
            datos.setNaudio(Fuente.get(lst_count).getNaudio());
            Arrlst.add(datos);

            playMp3(Fuente.get(lst_count).getNaudio()); //Reproducir pista de audio al agregar un nuevo renglon al lst
        return Arrlst;
    }

    public void playMp3(String Audio) {

        MediaPlayer mPlayer = MediaPlayer.create(context, context.getResources().getIdentifier(Audio, "raw", context.getPackageName()));
        mPlayer.start();
    }
}
