package com.ashutosh1234ojha.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn

/**
 * Created by Ashutosh Ojha on 05,January,2022
 */
class PhotoViewModel(private val apiInterface: ApiInterface) :ViewModel() {

    val pageList= Pager(PagingConfig(100)){
        PhotoDataSource(apiInterface)
    }.flow
}