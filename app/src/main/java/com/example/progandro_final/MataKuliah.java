package com.example.progandro_final;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MataKuliah extends AppCompatActivity {
    private FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = firebaseFirestore.collection("MataKuliah");

    private NoteMatkulAdapter noteMatkulAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matakuliah);

        FloatingActionButton buttonAddNote = findViewById(R.id.tambah);
        buttonAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MataKuliah.this, NewMatkul.class));
            }
        });
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query query = collectionReference.orderBy("matakuliah", Query.Direction.ASCENDING);

        FirestoreRecyclerOptions<NoteMatkul> options = new FirestoreRecyclerOptions.Builder<NoteMatkul>()
                .setQuery(query, NoteMatkul.class)
                .build();

        noteMatkulAdapter = new NoteMatkulAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMataKuliah);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(noteMatkulAdapter);
        noteMatkulAdapter.notifyDataSetChanged();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteMatkulAdapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);

        //subject firestore info on click interface
        noteMatkulAdapter.setOnClickItemListener(new NoteMatkulAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                NoteMatkul noteMatkul = documentSnapshot.toObject(NoteMatkul.class);
                String matakuliah = documentSnapshot.getId();
                String path = documentSnapshot.getReference().getPath();
                Toast.makeText(MataKuliah.this, "Position " + position + " Mata Kuliah : " + matakuliah, Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        noteMatkulAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (noteMatkulAdapter != null) {
            noteMatkulAdapter.stopListening();
        }
    }
}
