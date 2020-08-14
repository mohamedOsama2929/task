package com.example.roomapplication.roomdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 2)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDB;

    public static NoteDatabase getInstance(Context context) {

        if (noteDB == null) {

            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static NoteDatabase buildDatabaseInstance(Context context) {

        return Room.databaseBuilder(context,
                NoteDatabase.class,
                "note database")
                .allowMainThreadQueries().build();
    }

    public abstract NoteDao getNoteDao();

    public void cleanUp() {

        noteDB = null;
    }
}
