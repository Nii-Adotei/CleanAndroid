package com.niiadotei.cleanandroid.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConcreteViewModel @Inject constructor(private val concreteDataRepository: ConcreteDataRepository): ViewModel() {
    private val _concreteData = MutableLiveData<ConcreteData>()

    val concreteData: LiveData<ConcreteData>
        get() = _concreteData

    fun loadConcreteData() {
        viewModelScope.launch {
            concreteDataRepository.getConcreteData().collect { data ->
                _concreteData.postValue(data)
            }
        }
    }
}