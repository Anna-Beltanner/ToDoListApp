package com.example.todolistapp.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity public class Note implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public int uid ;

    @ColumnInfo (name = "text")
    public String text;
    @ColumnInfo (name = "timeStamp")
    public Long timeStamp;
    @ColumnInfo (name = "isDone")
    public Boolean isDone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return uid == note.uid &&
                Objects.equals(text, note.text) &&
                Objects.equals(timeStamp, note.timeStamp) &&
                Objects.equals(isDone, note.isDone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, text, timeStamp, isDone);
    }

    public Note() {


    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
