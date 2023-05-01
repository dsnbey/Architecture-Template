package com.example.rxroombasictrysample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rxroombasictrysample.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.disposables.CompositeDisposable;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements InterfaceToPass{

    private ActivityMainBinding b;
    private VM vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityMainBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        vm = new ViewModelProvider(this).get(VM.class);
        //vm.btnClicked(this);
        setContentView(view);
        vm.btnClicked(this);





        b.btn.setOnClickListener( e -> {
            //Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
            vm.btnClicked(this);
        });

    }

    @Override
    public void updateText(String str) {
        Toast.makeText(this, "here ", Toast.LENGTH_SHORT).show();
        b.textView.setText(str);
    }


}