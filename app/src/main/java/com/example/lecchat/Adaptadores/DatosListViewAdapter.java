package com.example.lecchat.Adaptadores;

import android.content.Context;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.lecchat.Esquema.Datos;
import com.example.lecchat.R;

import java.util.ArrayList;
import java.util.List;

public class DatosListViewAdapter extends ArrayAdapter<Datos> {

    List<Datos> data = new ArrayList<>();

    public DatosListViewAdapter(Context context, List<Datos> datos) {
        super(context, R.layout.listview_chats, datos);
        data = datos;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public View getView(int pos, View v, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemview = inflater.inflate(R.layout.listview_chats, null);

        TextView lblData = (TextView)itemview.findViewById(R.id.lblData);
        lblData.setText(data.get(pos).getDatos());

        return itemview;
    }
}
