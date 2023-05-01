package com.example.rxroombasictrysample;

import static androidx.fragment.app.FragmentManager.TAG;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;
import androidx.room.Insert;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.disposables.Disposable;

@HiltViewModel
public class VM extends ViewModel{

    private UC uc;

    @Inject
    public VM(UC uc) {
        this.uc = uc;
    }

    public void btnClicked(InterfaceToPass passed) {
        //Log.d(TAG, " here ");
        uc.btnClicked(passed);
        //Log.d(TAG, "here too");
    }
}
