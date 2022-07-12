package com.niiadotei.cleanandroid.di

import android.content.Context
import com.niiadotei.cleanandroid.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MainTextFormatter @Inject constructor(@ApplicationContext private val applicationContext: Context) {

    fun getCounterText(count: Int) = applicationContext.getString(R.string.total_request_count, count)
}