package com.example.template.mvvm;

import android.view.View;
import android.widget.EditText;


import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.template.storage.SomeData;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FistViewModel extends ViewModel{

    Repository repository;
    SomeData someData;
    Adapter adapter;
    RecyclerView recyclerView;


   public  ObservableField<String> content = new ObservableField<>();
   public ObservableBoolean hasError = new ObservableBoolean();

    @Inject
    public FistViewModel(Repository repository, SomeData someData, Adapter adapter) {
        this.repository = repository;
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
            repository.someDataDAO.add(someData);
            updateList();
            content.set("");
            hasError.set(false);
        }
    }

    void loadSavedSomeData(){
        adapter.fistViewModel = this;
        recyclerView.setAdapter(adapter);
        updateList();
    }

    void updateList(){
        List<SomeData> someData = repository.someDataDAO.getAll();
        adapter.setData(someData);
    }

    public void delete(SomeData someData){
        repository.someDataDAO.delete(someData);
        updateList();
    }

    // can be simple relocate into: public class MyBindingAdapter
    @BindingAdapter({"app:errorText", "app:show"})
    public static void setErrorText (EditText editText, String errorText, boolean show){
        if (show) {
            editText.setError(errorText);
        }
    }

}
