package com.example.roomapplication.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note table")
class Note(@field:ColumnInfo(name = "name") var name: String, @field:ColumnInfo(name = "age") var age: String, @field:ColumnInfo(name = "jobTitle") var jobTitle: String, @field:ColumnInfo(name = "gender") var gender: String) {
    @JvmField
    @PrimaryKey(autoGenerate = true)
    var id = 0

}