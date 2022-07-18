package com.example.lecchat.Adaptadores;

import android.content.Context;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.lecchat.Esquema.Datos;
import com.example.lecchat.ProcesosG.DataForLst;
import com.example.lecchat.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DatosListViewAdapter extends ArrayAdapter<Datos> {

    ArrayList<Datos> Dialog = new ArrayList<>();

    public DatosListViewAdapter(Context context, ArrayList<Datos> datos) {
        super(context, R.layout.listview_chats, datos);
        Dialog = datos;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public View getView(int pos, View v, ViewGroup vg) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemview = inflater.inflate(R.layout.listview_chats, null);

        TextView lblDialog = (TextView)itemview.findViewById(R.id.lblData);
        lblDialog.setText(Dialog.get(pos).getDialogo());

        TextView lblCancion = (TextView)itemview.findViewById(R.id.lblaudio);
        lblCancion.setText(Dialog.get(pos).getNaudio());

        ImageView img1 = (ImageView) itemview.findViewById(R.id.img);
        ImageView img2 = (ImageView) itemview.findViewById(R.id.img2);

        if(Dialog.get(pos).getPersona() == 1) {
            img1.setImageResource(R.drawable.m);
            img2.setImageResource(R.drawable.audio2);
        }

        else if (Dialog.get(pos).getPersona()==2) {
            img1.setImageResource(R.drawable.audio);
            img2.setImageResource(R.drawable.h);
        }

        return itemview;
    }

}
