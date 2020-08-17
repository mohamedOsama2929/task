package com.example.roomapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.roomapplication.roomdb.Note
import com.example.roomapplication.roomdb.NoteDatabase
import com.example.roomapplication.roomdb.NoteDatabase.Companion.getInstance
import java.util.*

class MainActivity : AppCompatActivity() {
  lateinit  var noteDB: NoteDatabase
   lateinit var nameEditTxt: EditText
   lateinit var ageEditTxt: EditText
  lateinit  var jobTitleEditTxt: EditText
   lateinit var addBtn: Button
   lateinit var getBtn: Button
   lateinit var genderSpinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        noteDB = getInstance(this)
        intiView()
        val genderItems = arrayOf(getString(R.string.male), getString(R.string.female))
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genderItems)
        genderSpinner.adapter = genderAdapter
        addBtn.setOnClickListener { addData() }
        getBtn.setOnClickListener { data }
    }

    private fun intiView() {
        nameEditTxt = findViewById(R.id.name)
        ageEditTxt = findViewById(R.id.age)
        jobTitleEditTxt = findViewById(R.id.jobTitle)
        genderSpinner = findViewById(R.id.gender)
        addBtn = findViewById(R.id.addBtn)
        getBtn = findViewById(R.id.getBtn)
    }

    private fun clearInputs() {
        Objects.requireNonNull(nameEditTxt!!.text).clear()
        Objects.requireNonNull(ageEditTxt!!.text).clear()
        Objects.requireNonNull(jobTitleEditTxt!!.text).clear()
    }

    private fun addData() {
        val note = noteCreator()
        inputIsEmpty(note)
        clearInputs()
    }

    private val data: Unit
        get() {
            showToastMessages(getString(R.string.get_data_message))
            goToResult()
        }

    private fun inputIsEmpty(note: Note) = if (nameEditTxt!!.text.toString() != "" &&
            ageEditTxt!!.text.toString() != "" &&
            jobTitleEditTxt!!.text.toString() != "" &&
            genderSpinner!!.selectedItem.toString() != "") {
        noteDB!!.noteDao?.insert(note)
        showToastMessages(getString(R.string.add_successfuly))
    } else {
        showToastMessages(getString(R.string.please_fill_data))
    }

    private fun noteCreator(): Note {
        return Note(nameEditTxt!!.text.toString(), ageEditTxt!!.text.toString(), jobTitleEditTxt!!.text.toString(), genderSpinner!!.selectedItem.toString())
    }

    private fun goToResult() {
        startActivity(Intent(this@MainActivity, ResultActivity::class.java))
    }

    private fun showToastMessages(input: String) {
        Toast.makeText(applicationContext, input, Toast.LENGTH_SHORT).show()
    }
}