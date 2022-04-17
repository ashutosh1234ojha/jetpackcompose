package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Ashutosh Ojha on 21,December,2021
 */
class CircularProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressBar(percentage = 0.8f, number = 200)

            }
        }
    }

    @Composable
    fun CircularProgressBar(
        percentage: Float,
        number: Int,
        fontSize: TextUnit = 28.sp,
        radius: Dp = 50.dp,
        color: Color = Color.Green,
        strokeWidth: Dp = 5.dp,
        animationDuration: Int = 5000,
        animationDelay: Int = 10
    ) {
        var animationPlayed by remember {
            mutableStateOf(false)
        }
        val curPercentage =
            animateFloatAsState(
                targetValue = if (animationPlayed) percentage else 0f,
                animationSpec = tween(
                    durationMillis = animationDuration,
                    delayMillis = animationDelay
                )
            )
        LaunchedEffect(key1 = true) {
            animationPlayed = true
        }

        Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)) {

            Canvas(modifier = Modifier.size(radius * 2f)) {
                drawArc(
                    color = color,
                    -90f,
                    360 * curPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }

            Text(
                text = (curPercentage.value * number).toInt().toString(),
                color = Color.Blue,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )

        }
    }
}