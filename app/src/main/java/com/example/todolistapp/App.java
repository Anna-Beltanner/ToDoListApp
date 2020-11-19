package com.example.todolistapp;

import android.app.Application;

import androidx.room.Room;

import com.example.todolistapp.data.AppDatabase;
import com.example.todolistapp.data.NoteDao;

public class App extends Application {

    private AppDatabase database;
    private NoteDao noteDao;

    private static App instance;
    public static App getInstance(){
        return instance;

    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,  "app-db-name" )
                .allowMainThreadQueries()
                .build();

        noteDao = database.noteDao();
    }

    public AppDatabase getDatabase() {
        return database;
    }

    public void getDatabase(AppDatabase database) {
        this.database = database;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }
    public void getNoteDao (AppDatabase database) {
        this.database = database;
    }
}
