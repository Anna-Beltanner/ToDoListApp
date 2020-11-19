package com.example.todolistapp.screens.mainscreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolistapp.App;
import com.example.todolistapp.model.Note;

import java.util.List;

public class MainViewModel extends ViewModel {

    private LiveData<List<Note>> noteLiveData = App.getInstance().getNoteDao().getAllLiveData();

    public LiveData<List<Note>> getNoteLiveData() {
        return noteLiveData;
    }
}
