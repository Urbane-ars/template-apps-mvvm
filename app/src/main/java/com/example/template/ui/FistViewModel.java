package com.example.template.ui;

import android.view.View;
import android.widget.EditText;


import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.datasource.db.SomeData;
import com.example.template.repository.MainRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FistViewModel extends ViewModel{

    MainRepository mainRepository;
    SomeData someData;
    Adapter adapter;


   public  ObservableField<String> content = new ObservableField<>();
   public ObservableBoolean hasError = new ObservableBoolean();

    @Inject
    public FistViewModel(MainRepository mainRepository, SomeData someData, Adapter adapter) {
        this.mainRepository = mainRepository;
        this.someData = someData;
        this.adapter = adapter;
    }


    public void addData(View view){
        String text = content.get();
        if (text == null || text.isEmpty()){
                hasError.set(true);
        }
        else {
            someData.content = text;
            mainRepository.someDataDAO.add(someData);
            updateList();
            content.set("");
            hasError.set(false);
        }
    }

    void loadSavedSomeData(){
        updateList();
    }

    void updateList(){
        List<SomeData> someData = mainRepository.someDataDAO.getAll();
        adapter.setData(someData);
    }

    public void delete(SomeData someData){
        mainRepository.someDataDAO.delete(someData);
        updateList();
    }

}
