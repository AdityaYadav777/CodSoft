package com.aditya.noteapp_codsoft.Room

import android.content.Context
import androidx.room.Room

object DbHandler {

    private var INSTANCE:NoteDb?=null

fun getDB(context: Context):NoteDb{

    if (INSTANCE==null){
        INSTANCE= Room.databaseBuilder(context,NoteDb::class.java,"KELA").allowMainThreadQueries() .build()
    }
    return INSTANCE!!
}

}