package com.example.todolistapp.screens.details;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.widget.Toolbar;;

import com.example.todolistapp.App;
import com.example.todolistapp.R;
import com.example.todolistapp.model.Note;

public class NoteDetailActivity extends AppCompatActivity {

    private static final String EXTRA_NOTE = "NoteDetailsActivity.EXTRA_NOTE";

    private Note note;
    private EditText editText;

    public static void start(Activity caller, Note note) {
        Intent intent = new Intent(caller, NoteDetailActivity.class);
        if (note != null) {
            intent.putExtra(EXTRA_NOTE, note);
        }

        caller.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_note_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        setTitle(getString(R.string.note_detail_title));

        editText = findViewById(R.id.text);

        if (getIntent().hasExtra(EXTRA_NOTE)) {

            note = getIntent().getParcelableExtra(EXTRA_NOTE);
            editText.setText(note.text);
        } else {

            note = new Note();


        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_details, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                finish();
                break;
            case  R.id.action_save:
                if(editText.getText().length() > 0){
                    note.text = editText.getText().toString();
                    note.isDone = false;
                    note.timeStamp = System.currentTimeMillis();

                    if(getIntent().hasExtra(EXTRA_NOTE)){
                        App.getInstance().getNoteDao().update(note);
                    }else {
                        App.getInstance().getNoteDao().insert(note);

                    }
                    finish();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
