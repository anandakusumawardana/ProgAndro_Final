package com.example.progandro_final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class NoteMatkulAdapter extends FirestoreRecyclerAdapter<NoteMatkul, NoteMatkulAdapter.NoteMatkulHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public NoteMatkulAdapter(@NonNull FirestoreRecyclerOptions<NoteMatkul> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull NoteMatkulHolder holder, int position, @NonNull NoteMatkul model) {
        holder.textViewMatkul.setText(model.getMataKuliah());
        holder.textViewSks.setText(model.getSks());
        holder.textViewDosen.setText(model.getDosen());
    }

    @NonNull
    @Override
    public NoteMatkulHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matakuliah_item, parent,false);
        return new NoteMatkulHolder(view);
    }

    public void deleteItem(int position){
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    class NoteMatkulHolder extends RecyclerView.ViewHolder{

        TextView textViewMatkul,textViewDosen,textViewSks,textViewPriority;

        public NoteMatkulHolder(@NonNull View itemView) {
            super(itemView);
            textViewMatkul = itemView.findViewById(R.id.text_view_matkul);
            textViewDosen = itemView.findViewById(R.id.text_view_dosen);
            textViewSks = itemView.findViewById(R.id.text_view_sks);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}
