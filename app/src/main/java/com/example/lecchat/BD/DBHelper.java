package com.example.lecchat.BD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    String tableDato = "CREATE TABLE dato (dato TEXT)";

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
