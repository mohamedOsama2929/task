package com.example.roomapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapplication.roomdb.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Note> mNotes;

    public NotesAdapter(List<Note> notes) {
        this.mNotes = notes;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.note_item, parent, false);
        return new ViewHolder(contactView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {

        Note note = mNotes.get(position);

        holder.nameTextView.setText("Name : " + note.getName());
        holder.ageTextView.setText("Age : " + note.getAge());
        holder.jobTitleTextView.setText("Job Title : " + note.getJobTitle());
        holder.genderTextView.setText("Gender : " + note.getGender());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView, ageTextView, jobTitleTextView, genderTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.result_name);
            ageTextView = itemView.findViewById(R.id.result_age);
            jobTitleTextView = itemView.findViewById(R.id.result_jobTitle);
            genderTextView = itemView.findViewById(R.id.result_gender);
        }
    }
}
