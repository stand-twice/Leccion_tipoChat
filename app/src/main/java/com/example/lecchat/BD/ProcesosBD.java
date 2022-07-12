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
        DbObj = new DBHelper(context,"Mensaje",null, 1);
    }


    public boolean SaveDato(Datos data) {

        try {
            SQLiteDatabase sql = DbObj.getWritableDatabase();

            if (sql != null) {
                ContentValues values = new ContentValues();
                values.put("dato", data.getDatos());

                sql.insert("dato", null, values);
                sql.close();
                return true;
            }

        }catch (Exception e) {}
        return false;
    }

    public List<Datos>ObtenerDatos() {

        try {
            SQLiteDatabase db = DbObj.getReadableDatabase();
            if (db != null){
                String[] campos = new String[]{"dato"};

                List<Datos> data = new ArrayList<>();

                Cursor cursor = db.query("dato",campos,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do {
                        Datos d = new Datos();
                        d.setDatos(cursor.getString(0));
                        data.add(d);
                    }while(cursor.moveToNext());
                }
                db.close();
                return data;
            }

        } catch (Exception e) {}
        return null;
    }
}
