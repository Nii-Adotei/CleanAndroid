package com.niiadotei.cleanandroid.utils

import retrofit2.http.GET

interface ConcreteDataService {

    @GET("/path")
    suspend fun getConcreteData(): ConcreteData
}