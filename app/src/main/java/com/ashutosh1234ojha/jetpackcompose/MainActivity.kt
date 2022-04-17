package com.ashutosh1234ojha.jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //   setContentView(R.layout.activity_main)
        setContent {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                // ColumnView()
                // RowView()
                //   Modifier()
//                val painter = painterResource(id = R.drawable.download1)
//                val text = "This is my image"
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(0.5f)
//                        .padding(16.dp)
//                ) {
//
//                }
//                Image(painter, text)
               // TextView()
                ColorBox()
            }
        }
    }


    @Composable
    fun TextView(name: String) {
        Text(text = "Your name is $name")
    }

    @Preview(showBackground = false)
    @Composable
    fun composeAblePreview() {
        //TextView(name = "KL")
        // ColumnView()
        // RowView()
        //Modifier()
//        val painter = painterResource(id = R.drawable.download1)
//        val text = "This is my image"
//        Image(painter = painter, text = text)
        TextView()
    }

    @Composable
    fun ColumnView() {
        Column(
            modifier = Modifier
                .background(color = Color.Yellow)
                .width(300.dp),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Your name is one")
            Text(text = "Your name is two")
            Text(text = "Your name is three")
        }

    }

    @Composable
    fun RowView() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = Color.Green),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Your row one")
            Text("Your row two")
            Text("Your row three")
        }
    }

    @Composable
    fun Modifier() {
        Column(
            modifier = Modifier
                .padding(90.dp) // margin
                .border(2.dp, Color.White)
                .background(color = Color.Green)
                .padding(40.dp)

        ) {
            Text(modifier = Modifier.offset(10.dp, 25.dp), text = "Your text  one")
            Text(text = "Your text  two")
        }
    }

    @Composable
    fun Image(painter: Painter, text: String) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp,
        ) {

            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(50.dp)
            ) {
                androidx.compose.foundation.Image(
                    painter = painter,
                    contentDescription = text,
                    //contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                ), startY = 300f
                            )
                        )
                ) {

                }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {

                    Text(text = text, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }

        }

    }

    @Composable
    fun TextView() {
        val fontFamily = FontFamily(
            Font(R.font.source_sans_pro_regular, FontWeight.Normal),
            Font(R.font.source_sans_pro_light, FontWeight.Light),
            Font(R.font.source_sans_pro_bold, FontWeight.Bold)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Yellow)
        ) {

//            Text(
//                text = "Jetpack Compose",
//                fontSize = 16.sp,
//                color = Color.Red,
//                fontFamily = fontFamily,
//                fontWeight = FontWeight.Normal,
//            )
//            Text(
//                modifier = Modifier.fillMaxWidth(),
//                text = "Jetpack Compose",
//                style = TextStyle(
//                    color = Color.Red,
//                    fontWeight = FontWeight.Bold,
//                    fontFamily = fontFamily,
//                    fontSize = 16.sp,
//                    textAlign = TextAlign.Center,
//                    textDecoration = TextDecoration.Underline
//                )
//            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append(
                            "J"
                        )
                    }
                    append("etpack ")
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append(
                            "C"
                        )
                    }
                    append("ompose")

                },
                style = TextStyle(
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontFamily = fontFamily,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            )
        }


    }
    @Composable
    fun ColorBox() {
        val color = remember {
            mutableStateOf(Color.Blue)
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color.value)
            .clickable {
                color.value =
                    Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)

            })


    }

}