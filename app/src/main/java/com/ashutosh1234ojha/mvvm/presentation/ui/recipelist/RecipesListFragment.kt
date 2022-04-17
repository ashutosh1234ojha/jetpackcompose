package com.ashutosh1234ojha.mvvm.presentation.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope

import com.ashutosh1234ojha.mvvm.presentation.components.FoodCategoryChip
import com.ashutosh1234ojha.mvvm.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * Created by Ashutosh Ojha on 17,March,2022
 */
@AndroidEntryPoint
class RecipesListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return ComposeView(requireContext()).apply {
            setContent {


                val recipes = viewModel.recipeList.value

                Column(modifier = Modifier.fillMaxWidth()) {

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.secondary,
                        elevation = 8.dp
                    ) {
                        Column {
                            Row {
                                TextField(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .background(Color.LightGray),
                                    value = viewModel.searchText.value,
                                    onValueChange = {
                                        viewModel.updateSearchText(it)
                                    },
                                    label = { Text(text = "Search") },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Text,
                                        imeAction = ImeAction.Search
                                    ),
                                    leadingIcon = {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = null
                                        )
                                    },

                                    keyboardActions = KeyboardActions(
                                        onSearch = {
                                            viewModel.apiSearchText("")

                                        }
                                    ),

                                    )
                            }


                            var scrollState = rememberLazyListState()
                            LazyRow(modifier = Modifier.padding(4.dp), state = scrollState) {
                              lifecycleScope.launch {scrollState.scrollToItem(viewModel.getScrollPosition()) }
                                //  scrollState.run { scrollState.scrollTo(viewModel.getScrollPosition()) }
                                itemsIndexed(items = getAllFoodCategories()) { item, category ->
                                    FoodCategoryChip(
                                        category = category.value,
                                        getFoodCategory(viewModel.categorySelected.value)!!
                                    )
                                    {
                                        Log.d("ItemClick", category.value)
                                        viewModel.categorySelected.value = category.value
                                        viewModel.apiSearchText("")
                                        viewModel.setScrollPosition(item)
                                    }


                                }

                            }
                        }
                    }


                    Spacer(modifier = Modifier.height(50.dp))
                    LazyColumn {
                        itemsIndexed(items = recipes) { item, recipe ->
                            run {
                                RecipeCard(recipe = recipe, onClick = {})


                            }
                        }
                    }
                }

            }
        }
    }


}