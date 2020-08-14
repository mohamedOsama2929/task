package com.example.roomapplication.roomdb;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Query("SELECT * FROM `note table`")
    List<Note> getAllNotes();

    @Query("DELETE FROM `note table`")
    void delete();
}
