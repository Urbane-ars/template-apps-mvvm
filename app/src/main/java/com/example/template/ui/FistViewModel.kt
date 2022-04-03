package com.example.template.ui

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.template.datasource.db.SomeData
import com.example.template.repository.MainRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FistViewModel @Inject constructor(var mainRepository: MainRepository, var someData: SomeData, var adapter: Adapter) : ViewModel() {

    var content = ObservableField<String>()
    var hasError = ObservableBoolean()

    fun addData(view: View?) {
        val text = content.get()
        if (text == null || text.isEmpty()) {
            hasError.set(true)
        } else {
            someData.content = text
            mainRepository.someDataDAO.add(someData)
            updateList()
            content.set("")
            hasError.set(false)
        }
    }

    fun loadSavedSomeData() {
        updateList()
    }

    fun updateList() {
        val someData = mainRepository.someDataDAO.all ?: emptyList()
        adapter.setData(someData)
    }

    fun delete(someData: SomeData?) {
        mainRepository.someDataDAO.delete(someData)
        updateList()
    }
}