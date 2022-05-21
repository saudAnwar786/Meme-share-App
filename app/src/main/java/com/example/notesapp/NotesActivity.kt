package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_notes.*

class NotesActivity : AppCompatActivity(), IRvadapter {
    lateinit var viewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        setSupportActionBar(toolbar2)

        if (supportActionBar != null){
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        toolbar2.setNavigationOnClickListener {
            onBackPressed()
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = NoteAdapter(this,this)
        recyclerView.adapter = adapter


        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer { list ->
            list?.let {
                adapter.updateList(it)
            }
        })
        val etTitleCopy = intent.getStringExtra("TITLE")
        val etContentCopy = intent.getStringExtra("CONTENT")
        viewModel.insertNote(NoteEntity(etTitleCopy.toString(),etContentCopy.toString()))
    }

    override fun onitemClicked(note: NoteEntity) {
       viewModel.deleteNote(note)
    }
}