package com.example.template.repository

import com.example.template.datasource.db.SomeDataDAO
import javax.inject.Inject

class MainRepository @Inject constructor() {
    @Inject
    lateinit var someDataDAO: SomeDataDAO
}
