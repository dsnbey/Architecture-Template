package com.example.rxroombasictrysample;

import static androidx.fragment.app.FragmentManager.TAG;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableCompletableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subscribers.DisposableSubscriber;

public class UC {

    private REPO repo;
    private int messageCount = 0;
    private String messagesTotal = "";
    private final String DEFAULT_MESSAGE = "clicked";
    private Disposable insertDisp;

    @Inject
    public UC(REPO repo) {
        this.repo = repo;
    }

    public void createMessage() {
        messageCount += 1;
        String msg = DEFAULT_MESSAGE + messageCount;
        Entitiy entitiy = new Entitiy(messageCount, msg);

        insertMessage(entitiy);
        //Log.d(TAG, "createMessage: ");
    }

    private void insertMessage(Entitiy entitiy) {
        insertDisp = repo.insertMessage(entitiy)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableCompletableObserver() {
                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    protected void onStart() {
                        super.onStart();
                    }
                });
        //insertDisp.dispose();
    }

    private void getMessage(InterfaceToPass passed) {
        repo.getMessage()
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSubscriber<String>() {
                    @Override
                    public void onNext(String s) {
                        messagesTotal += s;
                        passed.updateText(messagesTotal);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void btnClicked(InterfaceToPass passed) {
        createMessage();
        getMessage(passed);
    }

}
