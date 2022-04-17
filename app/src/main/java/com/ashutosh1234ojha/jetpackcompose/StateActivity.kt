package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

/**
 * Created by Ashutosh Ojha on 12,December,2021
 */
class StateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color = remember {
                mutableStateOf(Color.Blue)
            }
            Column(modifier = Modifier.fillMaxSize()) {
//                ColorBox(
//                    Modifier
//                        .fillMaxSize()
//                        .weight(1f),
//                    { color.value = it })
                ColorBox(
                    Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) { c -> color.value = c }

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .background(color.value)
                )

            }

        }
    }

    @Composable
    fun ColorBox(modifier: Modifier, updateColor: (Color) -> Unit) {

        Box(modifier = modifier
            .clickable {
                updateColor(
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
                )

            })


    }
}