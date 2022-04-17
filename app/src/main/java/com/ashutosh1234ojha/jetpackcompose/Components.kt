package com.ashutosh1234ojha.jetpackcompose

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import okhttp3.internal.wait


/**
 * Created by Ashutosh Ojha on 26,December,2021
 */
@ExperimentalFoundationApi
@Composable
fun ProfileScreen() {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        TopBar(
            heading = "Ashutosh", Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )
        ProfileSection()
        ProfileDescription(
            "Programming Mentor",
            "10 years of coding experience\n" + "And still counting",
            "https://developer.android.com/",
            listOf("Ashutosh", "Ojha", "Ankur"),
            5
        )
        ButtonSection(modifier = Modifier.padding(4.dp))
        HighLightSection(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            list = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Youtuve"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.download1),
                    text = "Q&A"
                ), ImageWithText(
                    image = painterResource(id = R.drawable.download),
                    text = "Discord"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_launcher_background),
                    text = "Telegram"
                )

            )
        )
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            list = listOf(
                ImageWithText(
                    image = painterResource(
                        id = R.drawable.download
                    ), text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(
                        id = R.drawable.download1
                    ), text = "MyTe"
                )
            )
        ) {
            selectedTabIndex = it
        }

        when (selectedTabIndex) {
            0 -> PostSection(
                list = listOf(
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download1),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download1),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download1),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download1),
                    painterResource(id = R.drawable.download),
                ), modifier = Modifier.fillMaxWidth()
            )
            1 -> PostSection(
                list = listOf(
                    painterResource(id = R.drawable.download1),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.download),
                    painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24)
                ), modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun TopBar(heading: String, modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .weight(.1f),
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            contentDescription = null // decorative element
        )

        Box(modifier = Modifier.weight(.7f), contentAlignment = Alignment.Center) {
            Text(

                text = heading,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        Icon(
            modifier = Modifier
                .size(24.dp)
                .weight(.1f),
            painter = painterResource(id = R.drawable.ic_baseline_notifications_24),
            contentDescription = null // decorative element
        )



        Icon(
            modifier = Modifier
                .size(24.dp)
                .weight(.1f),
            painter = painterResource(id = R.drawable.ic_baseline_more_vert_24),
            contentDescription = null // decorative element
        )
    }


}


@Composable
fun ProfileSection() {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
    ) {

        RoundImage(
            Modifier
                .weight(0.4f)
                .size(100.dp),
            painterResource(id = R.drawable.download1)
        )
        StatSection(
            Modifier.weight(0.6f),
        )

    }
}

@Composable
fun RoundImage(
    modifier: Modifier, image: Painter
) {
//    Image(
//        painter = image,
//        contentDescription = null,
//        modifier = modifier
//            .aspectRatio(1f, true)
//            .border(width = 2.dp, shape = CircleShape, color = Color.LightGray)
//            .padding(5.dp)
//            .clip(shape = CircleShape)
//    )
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, true)
            .border(width = 2.dp, shape = CircleShape, color = Color.LightGray)
            .padding(5.dp)
            .clip(shape = CircleShape)
    )

}

@Composable
fun StatSection(modifier: Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        ProfileStat(modifier = Modifier.weight(0.2f), number = "601", text = "Posts")
        ProfileStat(modifier = Modifier.weight(0.2f), number = "99.8K", text = "Followers")
        ProfileStat(modifier = Modifier.weight(0.2f), number = "72", text = "Followers")
    }


}

@Composable
fun ProfileStat(modifier: Modifier, number: String, text: String) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, color = Color.Black, fontWeight = FontWeight.Bold)
        Text(text = number)

    }

}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url: String,
    followedBy: List<String>,
    otherCount: Int
) {
    val letterSpacing = 0.5.sp
    val lineHeight = 20.sp
    val text = AnnotatedString("url")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        Text(
            text = displayName,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )
        Text(
            text = url, Modifier.clickable { Log.d("Clciked", "Refidres" + url) },
            color = Color.Blue,
            fontWeight = FontWeight.Normal,
            letterSpacing = letterSpacing,
            lineHeight = lineHeight
        )

        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)
                append("Followed By ")
                //   pushStyle(boldStyle)
                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < followedBy.size - 1) {
                        append(", ")
                    }
                }
                if (followedBy.size > 2) {
                    append(" and ")
                    pushStyle(boldStyle)
                    append("$otherCount others")
                }
            }, letterSpacing = letterSpacing, lineHeight = lineHeight
        )


    }
}

@Composable
fun ButtonSection(modifier: Modifier) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val minWidth = 30.dp
        val minHeight = 30.dp
        ActionButton(
            modifier = Modifier.defaultMinSize(minWidth = minWidth, minHeight = minHeight),
            text = "Following",
            icon = Icons.Default.ArrowDropDown
        )
        ActionButton(
            modifier = Modifier.defaultMinSize(minWidth = minWidth, minHeight = minHeight),
            text = "Message",
            null
        )
        ActionButton(
            modifier = Modifier.defaultMinSize(minWidth = minWidth, minHeight = minHeight),
            text = "Email",
            icon = Icons.Default.ArrowDropDown
        )
        ActionButton(
            modifier = Modifier.defaultMinSize(minWidth = minWidth, minHeight = minHeight),
            null, icon = Icons.Default.ArrowDropDown
        )
    }

}

@Composable
fun ActionButton(modifier: Modifier, text: String?, icon: ImageVector?) {
    Row(
        modifier = modifier
            .padding(6.dp)
            .border(
                shape = RoundedCornerShape(5.dp),
                width = 1.dp,
                color = Color.Gray
            )
            .padding(5.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (text != null) {
            Text(text = text, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        }
        if (icon != null) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
        }

    }
}

data class ImageWithText(var image: Painter, var text: String)

@Composable
fun HighLightSection(modifier: Modifier = Modifier, list: List<ImageWithText>) {
    LazyRow(modifier = modifier) {
        items(list.size) {
            Column(
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center, modifier = Modifier.padding(10.dp)
            ) {

                RoundImage(modifier = Modifier.size(70.dp), image = list[it].image)
                Text(
                    text = list[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    list: List<ImageWithText>, onTabSelected: (selectedIndex: Int) -> Unit,

    ) {
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val inactiveColor = Color(0xFF777777)
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = Color.Transparent,
        contentColor = Color.Black,
        modifier = modifier
    ) {

        list.forEachIndexed { index, item ->
            androidx.compose.material.Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = Color.Black,
                unselectedContentColor = inactiveColor,
                onClick = {
                    selectedTabIndex = index
                    onTabSelected(index)
                }) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = if (selectedTabIndex == index) Color.Black else inactiveColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(20.dp)
                )
            }
        }


    }
}

@ExperimentalFoundationApi
@Composable
fun PostSection(list: List<Painter>, modifier: Modifier = Modifier) {

    LazyVerticalGrid(cells = GridCells.Fixed(3), modifier = Modifier.scale(1.01f)) {
        items(list.size) {
            Image(
                painter = list[it],
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(color = Color.White, width = 1.dp)
            )
        }
    }
}

