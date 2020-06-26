package com.example.template.mvvm;

import android.view.View;
import android.widget.EditText;


import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.template.storage.SomeData;

import java.util.List;

import javax.inject.Inject;

public class FistViewModel extends ViewModel{

    Repository repository;
    SomeData someData;


   public ObservableField<String> texts = new ObservableField<>();
   public  ObservableField<String> content = new ObservableField<>();
   public ObservableBoolean hasError = new ObservableBoolean();

    @Inject
    public FistViewModel(Repository repository, SomeData someData) {
        this.repository = repository;
        this.someData = someData;
    }


    public void addData(View view){
        String text = content.get();
        if (text == null || text.isEmpty()){
                hasError.set(true);
        }
        else {
            someData.content = text;
            repository.someDataDAO.add(someData);
            loadSavedSomeData();
            content.set("");
            hasError.set(false);
        }

    }

    void loadSavedSomeData(){
        List<SomeData> someDataList = repository.someDataDAO.getAll();
        if (someDataList.size() == 0) return;

        StringBuilder stringBuilder = new StringBuilder();
        for (SomeData someData: someDataList
        ) {
            stringBuilder.append(someData.toString());
            stringBuilder.append("\n");
        }
        texts.set(stringBuilder.toString().trim());

    }

    // can be simple relocate into: public class MyBindingAdapter
    @BindingAdapter({"app:errorText", "app:show"})
    public static void setErrorText (EditText editText, String errorText, boolean show){
        if (show) {
            editText.setError(errorText);
        }
    }

}
