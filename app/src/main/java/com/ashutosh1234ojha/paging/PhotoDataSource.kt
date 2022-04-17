package com.ashutosh1234ojha.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ashutosh1234ojha.paging.ApiInterface
import com.ashutosh1234ojha.paging.data.Hit

/**
 * Created by Ashutosh Ojha on 05,January,2022
 */
class PhotoDataSource(private val apiInterface: ApiInterface) : PagingSource<Int, Hit>() {
    override fun getRefreshKey(state: PagingState<Int, Hit>): Int? {
//        return null
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index.
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        try {
            val currentPageList = params.key ?: 1
            val response = apiInterface.getPhoto(currentPageList)
            val responseList = mutableListOf<Hit>()
            val data = response.body()?.hits ?: emptyList()
            responseList.addAll(data)

            val prevKey = if (currentPageList == 1) {
                null
            } else {
                currentPageList - 1
            }

            return LoadResult.Page(responseList, prevKey, currentPageList.plus(1))
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}