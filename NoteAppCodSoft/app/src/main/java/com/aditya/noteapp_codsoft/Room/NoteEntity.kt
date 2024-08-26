package com.aditya.noteapp_codsoft.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteEntity(
    val title:String,
    val data:String,
    @PrimaryKey(autoGenerate = true)
    val id:Int=0
)
