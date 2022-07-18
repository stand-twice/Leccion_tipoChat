package com.example.lecchat.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    String tableDato = "CREATE TABLE conversacion (id INTEGER PRIMARY KEY, lecciones_id INTEGER, persona INTEGER, dialogo TEXT, N_audio TEXT)";

    public DBHelper(Context contex, String dbName, SQLiteDatabase.CursorFactory cursor, int dbVersion){
        super(contex,dbName,cursor,dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(tableDato);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int lastDb, int newDb){

    }

}
