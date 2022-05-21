package com.example.notesapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes_table")
 class NoteEntity(val title : String ,
    val content : String,
){
    @PrimaryKey(autoGenerate = true) var id = 0
 }