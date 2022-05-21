package com.example.notesapp

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val repository: NoteRepository
    val allNotes : LiveData<List<NoteEntity>>

    init {
        val dao = NoteDatabase.getInstance(application).getNotedao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes

    }
    fun deleteNote(note : NoteEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }
    fun insertNote(note: NoteEntity) =viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

}