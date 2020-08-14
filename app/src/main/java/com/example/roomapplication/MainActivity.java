package com.example.roomapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.roomapplication.roomdb.Note;
import com.example.roomapplication.roomdb.NoteDatabase;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public NoteDatabase noteDB;
    public EditText nameEditTxt, ageEditTxt, jobTitleEditTxt;
    public Button addBtn, getBtn;

    public Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDB = NoteDatabase.getInstance(this);

        intiView();

        String[] genderItems = new String[]{"Male", "Female"};

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, genderItems);
        genderSpinner.setAdapter(genderAdapter);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });
        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();

            }
        });


    }

    private void intiView() {
        nameEditTxt = findViewById(R.id.name);
        ageEditTxt = findViewById(R.id.age);
        jobTitleEditTxt = findViewById(R.id.jobTitle);
        genderSpinner = findViewById(R.id.gender);
        addBtn = findViewById(R.id.addBtn);
        getBtn = findViewById(R.id.getBtn);
    }

    private void clearInputs() {
        Objects.requireNonNull(nameEditTxt.getText()).clear();
        Objects.requireNonNull(ageEditTxt.getText()).clear();
        Objects.requireNonNull(jobTitleEditTxt.getText()).clear();
    }

    private void addData() {
        Note note = noteCreator();
        inputIsEmpty(note);
        clearInputs();
    }

    private void getData() {
        showToastMessages(getString(R.string.get_data_message));
        goToResult();
    }

    private void inputIsEmpty(Note note) {
        if (!nameEditTxt.getText().toString().matches("") &&
                !ageEditTxt.getText().toString().matches("") &&
                !jobTitleEditTxt.getText().toString().matches("") &&
                !genderSpinner.getSelectedItem().toString().matches("")) {

            noteDB.getNoteDao().insert(note);
            showToastMessages(getString(R.string.add_successfuly));
        } else {
            showToastMessages(getString(R.string.please_fill_data));
        }
    }

    private Note noteCreator() {
        return new Note(nameEditTxt.getText().toString(), ageEditTxt.getText().toString(), jobTitleEditTxt.getText().toString(), genderSpinner.getSelectedItem().toString());
    }

    private void goToResult() {
        startActivity(new Intent(MainActivity.this, ResultActivity.class));
    }

    private void showToastMessages(String input) {
        Toast.makeText(getApplicationContext(), input, Toast.LENGTH_SHORT).show();
    }
}