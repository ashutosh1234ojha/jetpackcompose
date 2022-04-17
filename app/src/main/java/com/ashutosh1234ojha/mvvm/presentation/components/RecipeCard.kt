package com.ashutosh1234ojha.mvvm.presentation.components

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ashutosh1234ojha.jetpackcompose.R
import com.ashutosh1234ojha.mvvm.domain.model.Recipe
import com.ashutosh1234ojha.mvvm.utils.DEFAULT_RECIPE_IMAGE
import com.ashutosh1234ojha.mvvm.utils.loadPicture

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */

@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick), elevation = 8.dp
    ) {

        Column() {
            recipe.featuredImage?.let { url ->
                val image = loadPicture(url = url, defaultImage = DEFAULT_RECIPE_IMAGE).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .requiredHeight(225.dp),
                        contentScale = ContentScale.Crop,
                    )
                }
            }

            recipe.title?.let {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = recipe.title,
                        modifier = Modifier
                            .fillMaxWidth(.85f)
                            .wrapContentWidth(Alignment.Start), style = MaterialTheme.typography.h5
                    )

                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically), style = MaterialTheme.typography.h6
                    )
                }
            }

        }
    }


}