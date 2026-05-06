package com.example.learnJetpackCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.learnJetpackCompose.ui.theme.DashboardGray
import com.example.learnJetpackCompose.ui.theme.DashboardRed
import com.example.learnJetpackCompose.ui.theme.LearnJCTheme

class DashboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnJCTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier.padding(innerPadding),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Dashboard()
                    }
                }
            }
        }
    }
}

@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = DashboardGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (redBorder) = createRefs()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .constrainAs(redBorder) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(color = DashboardRed)
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .height(60.dp)
                        .padding(8.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Zomato",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }

                Image(
                    painterResource(id = R.drawable.profile), contentDescription = null,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .clickable {})
            }
        }

        var searchText by rememberSaveable {
            mutableStateOf("")
        }
        TextField(
            value = searchText, onValueChange = { searchText = it },
            label = { Text(text = "Search restaurants...") },
            trailingIcon = {
                Image(
                    painterResource(R.drawable.search), contentDescription = null,
                    modifier = Modifier
                        .size(38.dp)
                        .padding(8.dp)
                )
            }, shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedPlaceholderColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                .background(Color.White, CircleShape)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                .shadow(5.dp, shape = RoundedCornerShape(25.dp))
                .height(150.dp)
                .background(color = DashboardRed)
        ) {
            val (bannerImage, flatText, freeText, couponText) = createRefs()
            Image(
                modifier = Modifier.constrainAs(bannerImage) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }, painter = painterResource(id = R.drawable.bannerimg),
                contentDescription = null
            )
            Text(
                text = "FLAT 50% OFF",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(flatText) {
                        top.linkTo(parent.top)
                        end.linkTo(bannerImage.start)
                        start.linkTo(parent.start)
                    }
            )
            Text(
                text = "Free Delivery + 10% Cashback",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier.constrainAs(freeText) {
                    top.linkTo(flatText.bottom)
                    start.linkTo(flatText.start)
                    end.linkTo(flatText.end)
                }
            )
            Text(
                text = "Coupon: FOOD50",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .constrainAs(couponText) {
                        top.linkTo(freeText.bottom)
                        start.linkTo(freeText.start)
                        end.linkTo(freeText.end)
                    }
            )
        }

        Text(
            text = "CATEGORIES",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.cake), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.pizza), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Pizza",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.sandwiches), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Sandwiches",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.noodles), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Noodles",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.pasta), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Pasta",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.biryani), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Biryani",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.burger), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Burger",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.icecream), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Ice Cream",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painterResource(R.drawable.dalrice), contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .shadow(3.dp, shape = RoundedCornerShape(10.dp))
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )

                Text(
                    text = "Dal Rice",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DisplayDashboard() {
    LearnJCTheme() {
        Dashboard()
    }
}
