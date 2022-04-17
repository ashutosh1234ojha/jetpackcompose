package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

/**
 * Created by Ashutosh Ojha on 15,December,2021
 */
class ConstraintActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val constraint = ConstraintSet {
                val greenBox = createRefFor("greenbox")
                val redBox = createRefFor("redbox")
                constrain(greenBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
                constrain(redBox) {
                    top.linkTo(parent.top)
                    start.linkTo(greenBox.end)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
            }

            ConstraintLayout(constraint, modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .background(Color.Green)
                        .layoutId("greenbox")
                )
                Box(
                    modifier = Modifier
                        .background(Color.Red)
                        .layoutId("redbox")
                )

            }
        }
    }
}