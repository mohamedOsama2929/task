package com.example.roomapplication.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 2)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao?
    fun cleanUp() {
        noteDB = null
    }

    companion object {
        private var noteDB: NoteDatabase? = null
        @JvmStatic
        fun getInstance(context: Context): NoteDatabase {
            if (noteDB == null) {
                noteDB = buildDatabaseInstance(context)
            }
            return noteDB as NoteDatabase
        }

        private fun buildDatabaseInstance(context: Context): NoteDatabase {
            return Room.databaseBuilder(context,
                    NoteDatabase::class.java,
                    "note database")
                    .allowMainThreadQueries().build()
        }
    }
}