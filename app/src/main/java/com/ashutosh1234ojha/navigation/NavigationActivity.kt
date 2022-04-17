package com.ashutosh1234ojha.navigation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Ashutosh Ojha on 15,April,2022
 */
class NavigationActivity :AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}