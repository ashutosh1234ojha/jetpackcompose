package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

/**
 * Created by Ashutosh Ojha on 15,December,2021
 */
class SideEffectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideEffectFun()
        }
    }


 //   var i=0
    @Composable
    fun SideEffectFun() {

//        var i by remember {
//            mutableStateOf(0)
//        }
     var i by remember {
         mutableStateOf(0)
     }

        Button(onClick = { i++ }) {
            Text(text = "Click $i")
        }
    }
}