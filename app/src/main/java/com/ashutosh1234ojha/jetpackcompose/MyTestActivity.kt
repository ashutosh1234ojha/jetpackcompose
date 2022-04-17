package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Created by Ashutosh Ojha on 14,February,2022
 */
class MyTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MyView() }
    }

    @Composable
    fun MyView() {
        var myState by remember {
            mutableStateOf(0)
        }
        return Column() {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = "Heading",
                fontSize = 30.sp
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 14.sp, text = "$myState",
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            )
            Button(
                modifier = Modifier.fillMaxWidth().padding(40.dp),
                onClick = {
                    myState += 1
                }
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp, text = "Click",
                )
            }
        }
    }

    fun increaseCount(){

    }
}