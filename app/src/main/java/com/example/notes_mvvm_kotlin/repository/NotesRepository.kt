package com.example.notes_mvvm_kotlin.repository

import androidx.lifecycle.LiveData
import com.example.notes_mvvm_kotlin.Dao.NotesDao
import com.example.notes_mvvm_kotlin.Model.Notes

class NotesRepository(val dao:NotesDao)
{
    fun getAllNotes():LiveData<List<Notes>>
    {
        return dao.getNotes()
    }

    fun getLowNotes():LiveData<List<Notes>> = dao.getLowNotes()

    fun getMediumNote():LiveData<List<Notes>> =dao.getMediumNotes()

    fun getHighNotes():LiveData<List<Notes>> = dao.getHighNotes()


    fun insertNotes(notes: Notes)
    {
        dao.insert(notes)
    }

    fun deleteNtoes(id:Int)
    {
        dao.deleteNote(id)
    }
    fun updateNotes(notes: Notes)
    {
        dao.updateNotes(notes)
    }
}