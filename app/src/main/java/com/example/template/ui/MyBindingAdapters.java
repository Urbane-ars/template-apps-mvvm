package com.example.template.ui;

import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class MyBindingAdapters {

    @BindingAdapter({"errorText", "show"})
    public static void setErrorText (EditText editText, String errorText, boolean show){
        if (show) {
            editText.setError(errorText);
        }
    }

    @BindingAdapter({"adapter"})
    public static void bindAdapter(RecyclerView view, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){
        view.setAdapter(adapter);
    }

}
