package com.ashutosh1234ojha.mvvm.domain.util

/**
 * Created by Ashutosh Ojha on 18,March,2022
 */
interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel): T
}