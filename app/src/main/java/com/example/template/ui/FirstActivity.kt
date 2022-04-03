package com.example.template.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.template.App
import com.example.template.R
import com.example.template.databinding.ActivityFirstBinding
import javax.inject.Inject

class FirstActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: FistViewModel

    @Inject
    lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        (application as? App)?.appComponent?.inject(this)
        val binding: ActivityFirstBinding = DataBindingUtil.setContentView(this, R.layout.activity_first)
        binding.fistViewModel = viewModel
        binding.adapter = adapter
        viewModel.loadSavedSomeData()
    }
}