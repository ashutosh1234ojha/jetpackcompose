package com.ashutosh1234ojha.mvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ashutosh1234ojha.jetpackcompose.R
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Ashutosh Ojha on 17,March,2022
 */
@AndroidEntryPoint
class HomeActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

}