package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

/**
 * Created by Ashutosh Ojha on 26,December,2021
 */
class InstaActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }

    @ExperimentalFoundationApi
    @Preview(showBackground = true)
    @Composable
    fun composeAblePreview() {
        ProfileScreen()

    }
}