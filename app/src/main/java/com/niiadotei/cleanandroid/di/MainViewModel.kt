package com.niiadotei.cleanandroid.di

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userService: UserService,
    private val userDao: UserDao,
    private val appDataStore: AppDataStore,
    private val mainTextFormatter: MainTextFormatter
): ViewModel() {
}