package com.example.template.mvp;


import com.example.template.storage.SomeData;

import java.util.List;

import javax.inject.Inject;

public class Presenter {


    Repository repository;
    SomeData someData;


    @Inject
    public Presenter(Repository repository, SomeData someData) {
        this.repository = repository;
        this.someData = someData;
    }

    private ViewContract viewContract;


    public void attachView(ViewContract firstActivity){
        viewContract = firstActivity;
        loadSavedSomeData();
    }

    public void addData(){
        String text = viewContract.getData();
        if ( text.isEmpty()){
            viewContract.showError();
        }
        else {
            someData.content = text;
            repository.someDataDAO.add(someData);
            loadSavedSomeData();
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
        viewContract.updateList(stringBuilder.toString().trim());
    }

}
