package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Created by Ashutosh Ojha on 13,December,2021
 */
class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnTwo()
        }
    }


    @Composable
    fun NormalColumn() {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            for (i in 1..50) {
                Text(modifier = Modifier.fillMaxWidth(), text = "Text $i")
            }
        }
    }

    @Composable
    fun LazyColumn() {
        //Here  items are loading when we scroll
        LazyColumn {
            items(50) {
                Text(modifier = Modifier.fillMaxWidth(), text = "Text  $it")
            }
        }
    }

    @Composable
    fun LazyColumnTwo() {
        //Here  items are loading when we scroll
        LazyColumn {
            itemsIndexed(listOf("Hello", "world", "its", "two")) { index, String ->
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Text $index  $String"
                )
            }
        }
    }
}