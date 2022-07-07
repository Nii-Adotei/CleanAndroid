package com.niiadotei.cleanandroid.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ConcreteDataRepository @Inject constructor(private val concreteDataService: ConcreteDataService) {

    fun getConcreteData(): Flow<ConcreteData> {
        return flow {
            val fooList = concreteDataService.getConcreteData()

            emit(fooList)
        }.flowOn(Dispatchers.IO)
    }
}