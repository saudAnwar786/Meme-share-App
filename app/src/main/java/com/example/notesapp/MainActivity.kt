package com.example.notesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            val etTitle = editTextTextPersonName.text.toString()
            val etContent = editTextTextPersonName2.text.toString()
            if (etContent.isNotEmpty() && etTitle.isNotEmpty()) {
                 val intent = Intent(this, NotesActivity::class.java)
                intent.putExtra("TITLE", etTitle)
                intent.putExtra("CONTENT", etContent)
                startActivityIfNeeded(intent,402)
            }else{
                Toast.makeText(this,"Please Enter Data ",Toast.LENGTH_SHORT).show()
            }

        }
        see_list.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }
    }



}

