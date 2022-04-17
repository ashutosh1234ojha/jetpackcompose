package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue



/**
 * Created by Ashutosh Ojha on 16,December,2021
 */
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var emailState by remember {
                mutableStateOf("")
            }

            LoginPage(emailState) { emailState = it }
//            LoginPage(emailState) { emailState = it }
        }
    }

    @Composable
    private fun LoginPage(emailState: String, lamda: (String) -> Unit) {

        var passwordState by remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(10.dp))
            Card(modifier = Modifier.size(100.dp), shape = CircleShape, elevation = 20.dp) {
                Image(painterResource(id = R.drawable.download), contentDescription = "")

            }

            TextField(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                value = emailState,
                onValueChange = lamda,
                label = { Text(text = "Enter  email") }, colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                )
            )

            TextField(
                modifier = Modifier
                    .padding(top = 5.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                value = passwordState,
                onValueChange = { passwordState = it },
                label = {
                    Text(text = "Enter  password")
                }, colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFFFFF)
                ), visualTransformation = PasswordVisualTransformation()
            )

            Button(modifier = Modifier.padding(top = 5.dp), onClick = {

                Toast.makeText(
                    this@TestActivity,
                    getMsg(emailState, passwordState), Toast.LENGTH_SHORT
                ).show()
            }) {
                Text(text = "Login")
            }
        }
    }

    private fun getMsg(emailState: String, passwordState: String): String {
        return if (emailState.isEmpty() || passwordState.isEmpty()) {
            "enter details"
        } else {
            "$emailState $passwordState"
        }

    }

    class HelloView : ViewModel() {
        private var _name: MutableLiveData<String> = MutableLiveData()
        var name: LiveData<String> = _name

    }
}