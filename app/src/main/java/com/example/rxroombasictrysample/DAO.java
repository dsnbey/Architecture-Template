package com.example.rxroombasictrysample;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface DAO {

    @Query("SELECT message FROM Entitiy ORDER BY `no` ASC LIMIT 1")
    Flowable<String> getMessage();

    @Insert
    Completable insertMessage(Entitiy entitiy);
}
