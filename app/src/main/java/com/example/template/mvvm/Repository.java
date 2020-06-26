package com.example.template.mvvm;



import com.example.template.storage.SomeDataDAO;

import javax.inject.Inject;



public class Repository {

    SomeDataDAO someDataDAO;


    @Inject
    public Repository(SomeDataDAO someDataDAO) {
        this.someDataDAO = someDataDAO;
    }


}
