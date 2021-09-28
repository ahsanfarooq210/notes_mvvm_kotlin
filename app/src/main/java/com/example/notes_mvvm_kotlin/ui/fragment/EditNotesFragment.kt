package com.example.notes_mvvm_kotlin.ui.fragment

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.notes_mvvm_kotlin.Model.Notes
import com.example.notes_mvvm_kotlin.R
import com.example.notes_mvvm_kotlin.ViewModel.NotesViewModel
import com.example.notes_mvvm_kotlin.databinding.FragmentEditNotesBinding
import java.util.*


class EditNotesFragment : Fragment()
{
    val notes by navArgs<EditNotesFragmentArgs>()
    lateinit var  binding:FragmentEditNotesBinding
    var priority:String="1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding= FragmentEditNotesBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment

        binding.editTitle.setText(notes.data.title)
        binding.editSubtitle.setText(notes.data.subTitle)
        binding.editNotes.setText(notes.data.notes)

        when(notes.data.priority)
        {
            "1"->{
                priority="1"
                binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pRed.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
            "2"->{
                priority="2"
                binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pGreen.setImageResource(0)
                binding.pRed.setImageResource(0)
            }
            "3"->{
                priority="3"
                binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
                binding.pGreen.setImageResource(0)
                binding.pYellow.setImageResource(0)
            }
        }

        binding.pGreen.setOnClickListener{
            priority="1"
            binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.pYellow.setOnClickListener{
            priority="2"
            binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pRed.setImageResource(0)
        }

        binding.pRed.setOnClickListener{
            priority="3"
            binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }

        binding.btnEditSaveNotes.setOnClickListener {
            updateNotes(it)
        }

        return binding.root
    }

    private fun updateNotes(it: View?)
    {
        val id=notes.data.id
        val title=binding.editTitle.text.toString()
        val subTitle=binding.editSubtitle.text.toString()
        val notes=binding.editNotes.text.toString()
        val d= Date()
        val notesDate:CharSequence = DateFormat.format("MMMM d, yyyy",d.time)

        val data= Notes(id=id,title=title,subTitle=subTitle,notes=notes,date=notesDate.toString(),priority)
        viewModel.updateNotes(data)

        Toast.makeText(context,"Notes updated successfully", Toast.LENGTH_SHORT).show()

        Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_homeFragment)

    }

}