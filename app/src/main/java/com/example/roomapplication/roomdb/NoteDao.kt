package com.example.roomapplication.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    fun insert(note: Note?)

    @get:Query("SELECT * FROM `note table`")
    val allNotes: List<Note?>?
}