package com.example.notes_mvvm_kotlin.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes_mvvm_kotlin.Model.Notes

@Dao
interface NotesDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note:Notes)

    @Query("select * from Notes where priority=3" )
    fun getHighNotes():LiveData<List<Notes>>

    @Query("select * from Notes where priority=2" )
    fun getMediumNotes():LiveData<List<Notes>>

    @Query("select * from Notes where priority=1" )
    fun getLowNotes():LiveData<List<Notes>>

    @Delete
    fun delete(note:Notes)

    @Update
    fun updateNotes(note:Notes)

    @Query("select * from Notes")
    fun getNotes():LiveData<List<Notes>>

    @Query("delete  from Notes where id=:id")
    fun deleteNote(id:Int)
}