package com.example.lecchat.ProcessAPI;

import android.content.Context;
import android.media.MediaPlayer;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.lecchat.Esquema.Datos;
import com.example.lecchat.Interfaces.DatosAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIProcess {

    ArrayList<Datos> Fuente = new ArrayList<>();
    ArrayList<Datos> Arrlst = new ArrayList<>();
    Context context;

    private void obtener(int leccion_id, Context c) {

        context = c;
        Retrofit retro = new Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create()).build();

        DatosAPI data = retro.create(DatosAPI.class);
        Call<Datos> call = data.find(leccion_id);
        call.enqueue(new Callback<Datos>() {
            @Override
            public void onResponse(Call<Datos> call, Response<Datos> response) {

                try {

                    if(response.isSuccessful()) {
                        Datos dat = response.body();
                        Fuente.add(dat);
                    }

                }catch (Exception e) {
                    Toast.makeText(c, "Error en traida de datos",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Datos> call, Throwable t) {
                Toast.makeText(c, "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

    public ArrayList<Datos> Preparardatos(int lst_count) {

        Datos datos = new Datos();

        datos.setId(Fuente.get(lst_count).getId());
        datos.setLecciones_id(Fuente.get(lst_count).getLecciones_id());
        datos.setPersona(Fuente.get(lst_count).getPersona());
        datos.setDialogo(Fuente.get(lst_count).getDialogo());
        datos.setNaudio(Fuente.get(lst_count).getNaudio());
        Arrlst.add(datos);

        return Arrlst;
    }

    public void playMp3(String Audio) {

        MediaPlayer mPlayer = MediaPlayer.create(context, context.getResources().getIdentifier(Audio, "raw", context.getPackageName()));
        mPlayer.start();
    }
}
