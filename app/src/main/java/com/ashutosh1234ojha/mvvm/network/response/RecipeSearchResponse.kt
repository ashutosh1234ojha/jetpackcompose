package com.ashutosh1234ojha.mvvm.network.response

import com.ashutosh1234ojha.mvvm.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */

data class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeDto>,
)