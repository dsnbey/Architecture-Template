package com.example.rxroombasictrysample;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entitiy.class}, version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {

    public abstract DAO dao();
}
