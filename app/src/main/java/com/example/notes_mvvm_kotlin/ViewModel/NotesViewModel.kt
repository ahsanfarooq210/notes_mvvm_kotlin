package com.example.notes_mvvm_kotlin.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notes_mvvm_kotlin.Database.NotesDatabase
import com.example.notes_mvvm_kotlin.Model.Notes
import com.example.notes_mvvm_kotlin.repository.NotesRepository

class NotesViewModel(application: Application):AndroidViewModel(application)
{
    val repository: NotesRepository

    init
    {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes)
    {
        repository.insertNotes(notes)
    }

    fun getLowNotes():LiveData<List<Notes>> = repository.getLowNotes()

    fun getMediumNote():LiveData<List<Notes>> = repository.getMediumNote()

    fun getHighNotes():LiveData<List<Notes>> = repository.getHighNotes()

    fun getNotes(): LiveData<List<Notes>> = repository.getAllNotes()
    fun deleteNotes(id:Int)
    {
        repository.deleteNtoes(id)
    }

    fun updateNotes(notes: Notes)
    {
        repository.updateNotes(notes)
    }
}