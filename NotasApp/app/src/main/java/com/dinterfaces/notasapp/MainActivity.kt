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

    private val notes = mutableListOf<Note>()
    lateinit var editTextTitle: EditText
    lateinit var editTextBody: EditText
    lateinit var listViewNotes : ListView
    lateinit var adapter: ArrayAdapter<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTitle = findViewById(R.id.title)
        editTextBody = findViewById(R.id.body)
        listViewNotes = findViewById(R.id.noteList)

        adapter = ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, notes)

        listViewNotes.adapter = adapter

        listViewNotes.setOnItemClickListener { adapterView, view, position, id ->

            val note = notes[position]
            editTextTitle.setText(note.titulo)
            editTextBody.setText(note.body)

        }

        listViewNotes.setOnItemLongClickListener { adapterView, view, position, id ->

            notes.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, resources.getString(R.string.noteRemoved), Toast.LENGTH_SHORT).show()
            true

        }

    }

    fun addNote(v: View) {

        if (editTextTitle.text.toString() != "") {

            val title = editTextTitle.text.toString()
            val body = editTextBody.text.toString()
            val date = Date()
            val nota = Note(title, body, date)
            notes.add(nota)
            adapter.notifyDataSetChanged()
            resetNotesViews()
            Toast.makeText(this, resources.getString(R.string.noteAdded), Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(this, resources.getString(R.string.emptyTitle), Toast.LENGTH_LONG).show()

        }

    }

    private fun resetNotesViews() {

        editTextTitle.setText("")
        editTextBody.setText("")

    }
}
