package com.example.progandro_final;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewMatkul extends AppCompatActivity {

    private EditText editTextMatkul, editTextSks, editTextDosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_matkul);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");

        editTextMatkul = findViewById(R.id.tambahMatkul);
        editTextSks = findViewById(R.id.tambahSks);
        editTextDosen = findViewById(R.id.tambahDosen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_matkul_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.save_matkul) {
            saveNote();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void saveNote(){
        String matkul = editTextMatkul.getText().toString();
        String dosen = editTextDosen.getText().toString();
        String sks = editTextSks.getText().toString();

        if (matkul.trim().isEmpty() || dosen.trim().isEmpty() || sks.trim().isEmpty()){
            Toast.makeText(this, "Insert The Field Before Continue", Toast.LENGTH_SHORT).show();
            return;
        }
        CollectionReference collectionReference = FirebaseFirestore.getInstance()
                .collection("MataKuliah");
        collectionReference.add(new NoteMatkul(matkul, dosen, sks));
        Toast.makeText(this, "Mata Kuliah Tertambah", Toast.LENGTH_SHORT).show();
        finish();
    }
}
