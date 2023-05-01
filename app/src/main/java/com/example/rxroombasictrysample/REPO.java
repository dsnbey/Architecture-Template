package com.example.rxroombasictrysample;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

public class REPO {

    private final DB db;
    private DAO dao;

    @Inject
    public REPO(DB db) {
        this.db = db;
        this.dao = db.dao();
    }

    public Flowable<String> getMessage() {
        return dao.getMessage();
    }

    public Completable insertMessage(Entitiy entitiy) {
        return dao.insertMessage(entitiy);
    }


}
