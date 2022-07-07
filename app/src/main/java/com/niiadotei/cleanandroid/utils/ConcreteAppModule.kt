package com.niiadotei.cleanandroid.utils

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ConcreteAppModule {

    @Singleton
    @Provides
    fun provideConcreteDataService(retrofit: Retrofit): ConcreteDataService = retrofit.create(ConcreteDataService::class.java)

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(15, TimeUnit.SECONDS).connectTimeout(15, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): MoshiConverterFactory = MoshiConverterFactory.create()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gsonConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder().baseUrl("schema://host.com").client(okHttpClient).addConverterFactory(gsonConverterFactory).build()
    }
}