package com.example.roomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.roomapplication.roomdb.Note;
import com.example.roomapplication.roomdb.NoteDatabase;

import java.util.List;

public class ResultActivity extends AppCompatActivity {

    public List<Note> notes;
    public NoteDatabase noteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        noteDB = NoteDatabase.getInstance(this);
        RecyclerView rvNotes = findViewById(R.id.recyclerView_result);
        notes = noteDB.getNoteDao().getAllNotes();
        NotesAdapter adapter = new NotesAdapter(notes);
        rvNotes.setAdapter(adapter);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }
}