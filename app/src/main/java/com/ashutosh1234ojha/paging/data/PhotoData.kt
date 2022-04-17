package com.ashutosh1234ojha.paging.data



data class PhotoData(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)