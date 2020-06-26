package com.example.template.mvvm;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.template.App;
import com.example.template.R;
import com.example.template.databinding.ActivityFirstBinding;


import javax.inject.Inject;


public class FirstActivity extends AppCompatActivity {

    @Inject
    FistViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Launcher Theme
        ((App) getApplication()).getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        ActivityFirstBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first);
        binding.setFistViewModel(viewModel);
        init();
    }

    void init(){
        viewModel.loadSavedSomeData();
    }






}
