package com.example.progandro_final;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MahasiswaData extends Fragment {
    private SQLiteDatabase sqLiteDatabase;
    private EditText nim, nama, email;
    private ListAdapter listAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.mahasiswa, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycleMahasiswa);
        listAdapter = new ListAdapter(getContext(),getAllItem());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(listAdapter);

        Button button = rootView.findViewById(R.id.addData);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nim = rootView.findViewById(R.id.nimInput);
                nama = rootView.findViewById(R.id.namaInput);
                email = rootView.findViewById(R.id.emailInput);
                if (nim.getText().toString().trim().length() == 0 &&
                        nama.getText().toString().trim().length()==0 &&
                        email.getText().toString().trim().length()==0){
                    return;
                }
                String nimMahasiswa, namaMahasiswa, emailMahasiswa;
                nimMahasiswa = nim.getText().toString();
                namaMahasiswa = nama.getText().toString();
                emailMahasiswa = email.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put(Data.dataMahasiswa.COLUMN_NIM,nimMahasiswa);
                contentValues.put(Data.dataMahasiswa.COLUMN_NAMA,namaMahasiswa);
                contentValues.put(Data.dataMahasiswa.COLUMN_EMAIL,emailMahasiswa);

                sqLiteDatabase.insert(Data.dataMahasiswa.TABLE_NAME,null,contentValues);
                listAdapter.swapCursor(getAllItem());

                nim.getText().clear();
                nama.getText().clear();
                email.getText().clear();
            }
        });
        return rootView;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
        sqLiteDatabase = databaseHelper.getReadableDatabase();
    }


    private Cursor getAllItem(){
        return  sqLiteDatabase.query(
                Data.dataMahasiswa.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
