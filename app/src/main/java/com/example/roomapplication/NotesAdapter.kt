package com.example.roomapplication

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapplication.roomdb.Note

class NotesAdapter(private val mNotes: List<Note>) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.note_item, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = mNotes[position]
        holder.nameTextView.text = "Name : " + note.name
        holder.ageTextView.text = "Age : " + note.age
        holder.jobTitleTextView.text = "Job Title : " + note.jobTitle
        holder.genderTextView.text = "Gender : " + note.gender
    }

    override fun getItemCount(): Int {
        return mNotes.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameTextView: TextView
        var ageTextView: TextView
        var jobTitleTextView: TextView
        var genderTextView: TextView

        init {
            nameTextView = itemView.findViewById(R.id.result_name)
            ageTextView = itemView.findViewById(R.id.result_age)
            jobTitleTextView = itemView.findViewById(R.id.result_jobTitle)
            genderTextView = itemView.findViewById(R.id.result_gender)
        }
    }

}