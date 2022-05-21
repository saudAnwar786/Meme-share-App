package com.example.notesapp

import android.content.Context
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class NoteAdapter(val context : Context, val listener : IRvadapter): RecyclerView.Adapter<NoteAdapter.NotesViewHolder>(){
    private val allNotes = ArrayList<NoteEntity>()
    inner class NotesViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val title  = itemView.findViewById<TextView>(R.id.textView)
        val conent = itemView.findViewById<TextView>(R.id.textView2)
        val deleteButton = itemView.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val viewHolder = NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_notes,parent,false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onitemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentNote = allNotes[position]
        holder.title.text = currentNote.title
        holder.conent.text = currentNote.content

    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    fun updateList(newList : List<NoteEntity>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface IRvadapter{
    fun onitemClicked(note:NoteEntity)
}