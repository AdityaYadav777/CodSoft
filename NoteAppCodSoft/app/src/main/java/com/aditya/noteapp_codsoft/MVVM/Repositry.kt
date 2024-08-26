package com.aditya.noteapp_codsoft.MVVM

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import com.aditya.noteapp_codsoft.Room.DbHandler
import com.aditya.noteapp_codsoft.Room.NoteEntity

class Repositry {


    fun insetData(data:NoteEntity,context: Context){
        val db=DbHandler.getDB(context).noteDao
        db.insertData(data)
        showMessage(context)
    }


    fun getData(context: Context): LiveData<List<NoteEntity>> {
        val db=DbHandler.getDB(context).noteDao
        return db.getData()
    }


    fun updateData(data: NoteEntity,context: Context){
        val db=DbHandler.getDB(context).noteDao
        db.updateData(data)
        showMessage(context)
    }

    fun deleteNote(noteEntity: NoteEntity,context: Context){
        val db=DbHandler.getDB(context).noteDao
        db.deleteNote(noteEntity)
        showMessage(context)
    }

    fun showMessage(context: Context) {
        Toast.makeText(context,"Done",Toast.LENGTH_SHORT).show()
    }

}