package com.example.template.mvvm;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.App;
import com.example.template.R;
import com.example.template.databinding.ActivityFirstBinding;


import javax.inject.Inject;


public class FirstActivity extends AppCompatActivity {

    @Inject
    FistViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getAppComponent().inject(this);
        ActivityFirstBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first);
        binding.setFistViewModel(viewModel);
        init();
    }

    void init(){
        RecyclerView recyclerView = findViewById(R.id.list_data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel.recyclerView = recyclerView;
        viewModel.loadSavedSomeData();
    }






}
