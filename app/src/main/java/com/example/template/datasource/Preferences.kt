package com.example.template.datasource

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast

class Preferences(private val context: Context) {
    private val settingName = "setting"
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(settingName, Context.MODE_PRIVATE)
    val isIntroShown: Boolean
        get() {
            Toast.makeText(context, "First start", Toast.LENGTH_LONG).show()
            return sharedPreferences.getBoolean("fistStart", true)
        }

    fun introFinished() {
        sharedPreferences.edit().putBoolean("fistStart", false).apply()
    }
}