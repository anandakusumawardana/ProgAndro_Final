package com.example.progandro_final;

import android.provider.BaseColumns;

public class Data {

    public Data(){

    }

    public static final class dataMahasiswa implements BaseColumns {
        public static final  String TABLE_NAME = "matakuliah";
        public static final  String COLUMN_NIM = "nim";
        public static final  String COLUMN_NAMA = "nama";
        public static final  String COLUMN_EMAIL = "email";
    }
}
