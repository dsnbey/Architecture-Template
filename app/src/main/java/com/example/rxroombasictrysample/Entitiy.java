package com.example.rxroombasictrysample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity()
public class Entitiy {

    @PrimaryKey
    public int no;
    public String message;

    public Entitiy(int no, String message) {
        this.no = no;
        this.message = message;
    }
}
