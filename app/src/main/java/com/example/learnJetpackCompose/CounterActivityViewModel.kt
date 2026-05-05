package com.example.learnJetpackCompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterActivityViewModel : ViewModel() {

    var counter by mutableStateOf(0)

    fun increment() {
        counter++
    }
}
