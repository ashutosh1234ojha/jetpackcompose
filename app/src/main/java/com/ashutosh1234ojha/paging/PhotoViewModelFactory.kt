package com.ashutosh1234ojha.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


/**
 * Created by Ashutosh Ojha on 05,January,2022
 */
class PhotoViewModelFactory(private val apiInterface: ApiInterface):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PhotoViewModel::class.java)){
            return PhotoViewModel(apiInterface)  as T
        }
        throw IllegalArgumentException("not found view model")
    }
}