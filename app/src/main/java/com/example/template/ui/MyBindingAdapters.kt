package com.example.template.ui

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

object MyBindingAdapters {
    @JvmStatic
    @BindingAdapter("errorText", "show")
    fun setErrorText(editText: EditText, errorText: String?, show: Boolean) {
        if (show) {
            editText.error = errorText
        }
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<ViewHolder?>?) {
        view.adapter = adapter
    }
}