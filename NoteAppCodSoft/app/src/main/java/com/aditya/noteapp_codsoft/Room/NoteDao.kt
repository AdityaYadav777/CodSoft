package com.aditya.noteapp_codsoft.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.util.concurrent.Flow

@Dao
interface NoteDao {


    @Query("select *from noteentity")
    fun getData():LiveData<List<NoteEntity>>


    @Insert
    fun insertData(noteEntity: NoteEntity)


    @Update
    fun updateData(noteEntity: NoteEntity)


    @Delete
    fun deleteNote(noteData:NoteEntity)




}