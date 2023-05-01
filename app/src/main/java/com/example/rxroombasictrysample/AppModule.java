package com.example.rxroombasictrysample;


import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public DB provideDB(@ApplicationContext Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                        DB.class, "DB").fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public DAO provideDAO(DB db) {
        return db.dao();
    }

    @Provides
    @Singleton
    public REPO provideREPO(DB db) {
        return new REPO(db);
    }

    @Provides
    @Singleton
    public UC provideUC(REPO repo) {return new UC(repo); }

}
