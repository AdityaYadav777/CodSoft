package com.aditya.noteapp_codsoft.Room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDb :RoomDatabase(){
abstract val noteDao:NoteDao


}