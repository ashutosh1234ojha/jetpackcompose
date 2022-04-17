package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * Created by Ashutosh Ojha on 15,December,2021
 */
class AnimationActicity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SetAnimation()
        }
    }

    @Composable
    fun SetAnimation() {
        var size by remember {
            mutableStateOf(200.dp)
        }
        val sizeAnimate by animateDpAsState(targetValue = size, tween(durationMillis = 3000,delayMillis = 300,easing = LinearOutSlowInEasing))
        Box(
            modifier = Modifier
                .size(sizeAnimate)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = { size += 50.dp }) {
                Text(text = "Click to increase")

            }

        }
    }
}