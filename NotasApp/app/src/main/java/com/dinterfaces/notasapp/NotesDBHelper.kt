package com.dinterfaces.notasapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteConstraintException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper

import java.util.ArrayList

class NotesDBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    @Throws(SQLiteConstraintException::class)
    fun insertNote(note: Note): Boolean {
        // Gets the data repository in write mode
        val db = writableDatabase

        // Create a new map of values, where column names are the keys
        val values = ContentValues()
        values.put(DBNotes.NoteEntry.COLUMN_NOTE_ID, note.id)
        values.put(DBNotes.NoteEntry.COLUMN_TITLE, note.titulo)
        values.put(DBNotes.NoteEntry.COLUMN_TEXT, note.body)
        values.put(DBNotes.NoteEntry.COLUMN_DATE, note.date)

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db.insert(DBNotes.NoteEntry.TABLE_NAME, null, values)

        return true
    }

    @Throws(SQLiteConstraintException::class)
    fun deleteNote(noteid: String): Boolean {
        // Gets the data repository in write mode
        val db = writableDatabase
        // Define 'where' part of query.
        val selection = DBNotes.NoteEntry.COLUMN_NOTE_ID + " LIKE ?"
        // Specify arguments in placeholder order.
        val selectionArgs = arrayOf(noteid)
        // Issue SQL statement.
        db.delete(DBNotes.NoteEntry.TABLE_NAME, selection, selectionArgs)

        return true
    }

    fun readNote(noteid: String): ArrayList<Note> {
        val notes = ArrayList<Note>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBNotes.NoteEntry.TABLE_NAME + " WHERE " + DBNotes.NoteEntry.COLUMN_NOTE_ID + "='" + noteid + "'", null)
        } catch (e: SQLiteException) {
            // if table not yet present, create it
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var titulo: String
        var body: String
        var date: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                titulo = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_TITLE))
                body = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_TEXT))
                date = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_DATE))

                notes.add(Note(noteid, titulo, body, date))
                cursor.moveToNext()
            }
        }
        return notes
    }

    fun readAllNotes(): ArrayList<Note> {
        val notes = ArrayList<Note>()
        val db = writableDatabase
        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery("select * from " + DBNotes.NoteEntry.TABLE_NAME, null)
        } catch (e: SQLiteException) {
            db.execSQL(SQL_CREATE_ENTRIES)
            return ArrayList()
        }

        var noteid: String
        var titulo: String
        var body: String
        var date: String
        if (cursor!!.moveToFirst()) {
            while (cursor.isAfterLast == false) {
                noteid = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_NOTE_ID))
                titulo = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_TITLE))
                body = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_TEXT))
                date = cursor.getString(cursor.getColumnIndex(DBNotes.NoteEntry.COLUMN_DATE))

                notes.add(Note(noteid, titulo, body, date))
                cursor.moveToNext()
            }
        }
        return notes
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "FeedReader.db"

        private val SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBNotes.NoteEntry.TABLE_NAME + " (" +
                    DBNotes.NoteEntry.COLUMN_NOTE_ID + " TEXT PRIMARY KEY," +
                    DBNotes.NoteEntry.COLUMN_TITLE + " TEXT," +
                    DBNotes.NoteEntry.COLUMN_TEXT + " TEXT," +
                    DBNotes.NoteEntry.COLUMN_DATE + " TEXT)"

        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DBNotes.NoteEntry.TABLE_NAME
    }

}