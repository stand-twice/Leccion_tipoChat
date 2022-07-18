package com.example.lecchat.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.lecchat.Esquema.Datos;

import java.util.ArrayList;
import java.util.List;

public class ProcesosBD {

    DBHelper DbObj;

    public ProcesosBD(Context context) {
        DbObj = new DBHelper(context,"Conversacion",null, 1);
    }


    public boolean SaveDato(Datos data) {

        try {
            SQLiteDatabase sql = DbObj.getWritableDatabase();

            if (sql != null) {
                ContentValues values = new ContentValues();
                values.put("id", data.getId());
                values.put("lecciones_id", data.getLecciones_id());
                values.put("persona", data.getPersona());
                values.put("dialogo", data.getDialogo());
                values.put("N_audio", data.getNaudio());

                sql.insert("conversacion", null, values);
                sql.close();
                return true;
            }

        }catch (Exception e) {}
        return false;
    }

    public ArrayList<Datos>ObtenerDatos(int id_leccion) {

        try {
            SQLiteDatabase db = DbObj.getReadableDatabase();
            if (db != null){
                String[] campos = new String[]{"id", "lecciones_id", "persona", "dialogo", "N_audio"};

                ArrayList<Datos> data = new ArrayList<>();

                //Cursor cursor = db.rawQuery("SELECT * FROM conversacion WHERE lecciones_id = " + id_leccion, null);

                Cursor cursor = db.query("conversacion",campos,null,null,null,null,null);
                if (cursor.moveToFirst()){

                    do {
                        if(cursor.getInt(1)==id_leccion) {
                            Datos d = new Datos();

                            d.setId(cursor.getInt(0));
                            d.setLecciones_id(cursor.getInt(1));
                            d.setPersona(cursor.getInt(2));
                            d.setDialogo(cursor.getString(3));
                            d.setNaudio(cursor.getString(4));
                            data.add(d);
                        }

                    }while(cursor.moveToNext());
                }
                db.close();
                return data;
            }

        } catch (Exception e) {}
        return null;
    }
}
