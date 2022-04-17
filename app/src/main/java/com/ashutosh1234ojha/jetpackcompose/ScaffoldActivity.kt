package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ashutosh Ojha on 13,December,2021
 */
class ScaffoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember { mutableStateOf("") }
            val scope = rememberCoroutineScope()

            Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    TextField(
                        value = textFieldState,
                        onValueChange = { textFieldState = it },
                        label = { Text("Label") },
                        singleLine = true,
                        modifier = Modifier
                            .background(
                                Color.Transparent
                            )
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick = {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(textFieldState)
                        }
                    }) {
                        Text(text = "Click Me")

                    }
                }

            }
        }
    }
}