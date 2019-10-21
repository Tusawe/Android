package com.dinterfaces.notasapp

import android.provider.BaseColumns
import android.provider.FontsContract

object DBNotes {

    class NoteEntry : BaseColumns {
        companion object {
            val TABLE_NAME = "notes"
            val COLUMN_NOTE_ID = "id"
            val COLUMN_TITLE = "titulo"
            val COLUMN_TEXT = "body"
            val COLUMN_DATE = "date"
        }
    }

}