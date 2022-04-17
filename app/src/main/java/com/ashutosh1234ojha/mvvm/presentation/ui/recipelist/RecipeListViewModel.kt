package com.ashutosh1234ojha.mvvm.presentation.ui.recipelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ashutosh1234ojha.mvvm.domain.model.Recipe
import com.ashutosh1234ojha.mvvm.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
@HiltViewModel
class RecipeListViewModel
@Inject
public constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String,
) : ViewModel() {

    val recipeList: MutableState<List<Recipe>> = mutableStateOf(listOf())
    val searchText = mutableStateOf("")
    val categorySelected = mutableStateOf("Chicken")
    private var scrollPostion = 0

    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            recipeList.value = getList()
////            recipeList.value = repository.search(token = token, 1, "")
//
//        }
        recipeList.value = getList()
    }

    fun getList(): ArrayList<Recipe> {
        val list = ArrayList<Recipe>()
        list.add(Recipe(title = "One", featuredImage = "df"))
        list.add(Recipe(title = "two", featuredImage = "df"))
        list.add(Recipe(title = "three", featuredImage = "df"))
        list.add(Recipe(title = "Four", featuredImage = "df"))

        return list

    }

    fun updateSearchText(str: String) {
        searchText.value = str
    }

    fun apiSearchText(str: String) {
        val list = ArrayList<Recipe>()
        list.add(Recipe(title = "SearchResultOne", featuredImage = "df"))
        list.add(Recipe(title = "SearchResultTwo", featuredImage = "df"))
        recipeList.value = list
    }

    fun getRepo() = repository

    fun getAuthToken() = token

    fun setScrollPosition(pos: Int) {
        scrollPostion = pos
    }

    fun getScrollPosition():Int {
       return scrollPostion
    }
}