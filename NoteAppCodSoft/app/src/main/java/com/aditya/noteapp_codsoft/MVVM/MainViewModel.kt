package com.aditya.noteapp_codsoft.MVVM

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aditya.noteapp_codsoft.Room.NoteEntity

class MainViewModel:ViewModel() {


    val repo=Repositry()

    fun getData(context: Context):LiveData<List<NoteEntity>>{
        return  repo.getData(context)
    }

    fun insertData(data:NoteEntity,context: Context){
        repo.insetData(data,context)
    }

    fun updateData(noteEntity: NoteEntity,context: Context){
             repo.updateData(noteEntity,context)
    }

    fun deleteNote(noteEntity: NoteEntity,context: Context){
repo.deleteNote(noteEntity,context)
    }


}