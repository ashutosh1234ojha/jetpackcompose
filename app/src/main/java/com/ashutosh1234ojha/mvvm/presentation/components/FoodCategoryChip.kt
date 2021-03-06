package com.ashutosh1234ojha.mvvm.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ashutosh1234ojha.mvvm.presentation.ui.recipelist.FoodCategory
import com.ashutosh1234ojha.mvvm.presentation.ui.recipelist.getFoodCategory

/**
 * Created by Ashutosh Ojha on 21,March,2022
 */

@Composable
fun FoodCategoryChip(
    category: String, selectedCategory: FoodCategory,
    onExecuteSearch: (a: String) -> Unit
) {
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = if (getFoodCategory(category)!! != selectedCategory) MaterialTheme.colors.primary else Color.Gray
    ) {
        Row(modifier = Modifier
            .clickable(
                onClick = {
                    onExecuteSearch(category)
                }
            )
        ) {
            Text(
                text = category,
                style = MaterialTheme.typography.body2,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
