package com.dinterfaces.notasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var notes = mutableListOf<Note>()
    lateinit var editTextTitle: EditText
    lateinit var editTextBody: EditText
    lateinit var listViewNotes : ListView
    lateinit var adapter: ArrayAdapter<Note>
    lateinit var notesDBHelper : NotesDBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesDBHelper = NotesDBHelper(this)

        editTextTitle = findViewById(R.id.title)
        editTextBody = findViewById(R.id.body)
        listViewNotes = findViewById(R.id.noteList)

        notes = notesDBHelper.readAllNotes()

        adapter = ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notes)

        listViewNotes.adapter = adapter

        listViewNotes.setOnItemClickListener { adapterView, view, position, id ->

            updateNote(position)

        }

        listViewNotes.setOnItemLongClickListener { adapterView, view, position, id ->

            removeNote(position)
            true

        }

    }

    private fun removeNote(position: Int) {
        var noteid = notes[position].id
        val result = notesDBHelper.deleteNote(noteid)
        if (result) {
            notes.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, resources.getString(R.string.noteRemoved), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, resources.getString(R.string.cantNoteRemoved), Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateNote(position: Int) {
        val note = notes[position]
        editTextTitle.setText(note.titulo)
        editTextBody.setText(note.body)
    }

    fun addNote(v: View) {

        if (editTextTitle.text.toString() != "") {

            val title = editTextTitle.text.toString()
            val body = editTextBody.text.toString()
            val date = Date().toString()
            var nota = Note(id = date+title+(Math.random()*1000), titulo = title, body = body, date = date)
            var result = notesDBHelper.insertNote(nota)
            if (result) {

                notes.add(nota)
                adapter.notifyDataSetChanged()
                resetNotesViews()
                Toast.makeText(this, resources.getString(R.string.noteAdded), Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, resources.getString(R.string.errorToAdd), Toast.LENGTH_LONG).show()

            }


        } else {

            Toast.makeText(this, resources.getString(R.string.emptyTitle), Toast.LENGTH_LONG).show()

        }

    }

    private fun resetNotesViews() {

        editTextTitle.setText("")
        editTextBody.setText("")

    }
}

