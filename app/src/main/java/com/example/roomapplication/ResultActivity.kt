package com.example.roomapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.roomdb.Note
import com.example.roomapplication.roomdb.NoteDatabase
import com.example.roomapplication.roomdb.NoteDatabase.Companion.getInstance

class ResultActivity : AppCompatActivity() {
    var notes: List<Note>? = null
    var noteDB: NoteDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        noteDB = getInstance(this)
        val rvNotes = findViewById<RecyclerView>(R.id.recyclerView_result)
        notes = noteDB!!.noteDao?.allNotes as List<Note>?
        val adapter = NotesAdapter(notes!!)
        rvNotes.adapter = adapter
        rvNotes.layoutManager = LinearLayoutManager(this)
    }
}