package com.example.learnJetpackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.learnJetpackCompose.ui.theme.LearnNavBottomSheetTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnNavBottomSheetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val fruits = listOf(
                        "Apple", "Banana", "Papaya", "Mango", "Orange", "WaterMelon", "Strawberry", "Kiwi", "Pomegranate", "Peach",
                        "Muskmelon", "Pear", "Cranberry", "Grape", "Guava", "Raspberry", "Pineapple", "Dragon Fruit", "Ica Apple", "Cherry",
                        "Apple", "Banana", "Papaya", "Mango", "Orange", "WaterMelon", "Strawberry", "Kiwi", "Pomegranate", "Peach",
                        "Muskmelon", "Pear", "Cranberry", "Grape", "Guava", "Raspberry", "Pineapple", "Dragon Fruit", "Ica Apple", "Cherry"
                    )
                    DisplayFruits(fruits)
                }
            }
        }
    }
}

@Composable
fun DisplayFruits(fruitsList: List<String>) {
//    Column {
//        fruitsList.forEach {
//            Text(text = " $it", fontSize = 30.sp, color = Color.Red)
//        }
//    }

//    LazyColumn() {
//        items(fruitsList) {
//            Text(text = " $it", fontSize = 30.sp, color = Color.Red)
//        }
//    }

    LazyRow() {
        items(fruitsList) {
            Text(text = " $it", fontSize = 28.sp, color = Color.Magenta)
        }
    }

}
