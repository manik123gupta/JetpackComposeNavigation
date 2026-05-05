package com.example.learnJetpackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learnJetpackCompose.ui.theme.LearnNavBottomSheetTheme

class CounterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnNavBottomSheetTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    Counter(paddingValues)
                }
            }
        }
    }
}

@Composable
fun Counter(paddingValues: PaddingValues, counterActivityViewModel: CounterActivityViewModel = viewModel()) {
//    var counter by remember {
//        mutableStateOf(0)
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Button(onClick = {
//            counter++
            counterActivityViewModel.increment()
        }) {
            Text(text = "Click Me")
        }

        Text(text = "Counter = ${counterActivityViewModel.counter}")
    }
}
