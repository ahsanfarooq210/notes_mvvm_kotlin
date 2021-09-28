package com.example.notes_mvvm_kotlin.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_mvvm_kotlin.Model.Notes
import com.example.notes_mvvm_kotlin.R
import com.example.notes_mvvm_kotlin.databinding.IitemNotesBinding
import com.example.notes_mvvm_kotlin.ui.fragment.HomeFragmentDirections

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>()
{
    class notesViewHolder(val binding: IitemNotesBinding) : RecyclerView.ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder
    {
        return notesViewHolder(IitemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int)
    {
        val data=notesList[position]
        holder.binding.notesTitle.text=data.title
        holder.binding.notesSubtitle.text=data.subTitle
        holder.binding.notesDate.text=data.date

        when(data.priority)
        {
            "1"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)
            }
            "2"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)
            }
            "3"->{
                holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)
            }
        }

        holder.binding.root.setOnClickListener{
            val action=HomeFragmentDirections.actionHomeFragmentToEditNotesFragment(data)
            Navigation.findNavController(it).navigate(action)

        }
    }

    override fun getItemCount(): Int = notesList.size
}