package com.example.notesapp

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val notedao : NoteDao) {
    val allNotes: LiveData<List<NoteEntity>> = notedao.getallNotes()

     suspend fun insert(note :NoteEntity){
        notedao.insert(note)
    }
    suspend fun delete(note: NoteEntity){
        notedao.delete(note)
    }
}