package com.example.progandro_final;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.progandro_final.Data.dataMahasiswa;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mahasiswa.db";


    public DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlMahasiswa = "CREATE TABLE " +
                dataMahasiswa.TABLE_NAME + " (" +
                dataMahasiswa.COLUMN_NIM + " TEXT NOT NULL PRIMARY KEY, " +
                dataMahasiswa.COLUMN_NAMA + " TEXT NOT NULL, " +
                dataMahasiswa.COLUMN_EMAIL + " TEXT NOT NULL " +
                ")";
        sqLiteDatabase.execSQL(sqlMahasiswa);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + dataMahasiswa.COLUMN_NIM);
        onCreate(sqLiteDatabase);
    }
}
