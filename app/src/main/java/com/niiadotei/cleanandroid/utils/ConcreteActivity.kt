package com.niiadotei.cleanandroid.utils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConcreteActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Screen()
        }
    }
}


@Composable
fun Screen(concreteViewModel: ConcreteViewModel = viewModel()) {
    concreteViewModel.loadConcreteData()

    UpdateText()
}

@Composable
fun UpdateText(concreteViewModel: ConcreteViewModel = viewModel()) {
    val concreteData by concreteViewModel.concreteData.observeAsState(ConcreteData("test", "test"))

    MessageView(text = concreteData.field1)
}

@Composable
fun MessageView(text: String) {
    Text(text = text)
}