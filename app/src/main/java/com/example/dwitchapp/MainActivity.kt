package com.example.dwitchapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color as Colors
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import com.example.dwitchapp.service.ApiClient
import com.example.dwitchapp.ui.theme.DwitchAppTheme


import com.example.dwitchapp.ui.theme.OpenColors
import kotlinx.coroutines.launch
import model.Order
import timber.log.Timber


class OrdersViewModel : ViewModel() {
    private val _orders = mutableStateOf<List<Order>>(emptyList())
    val orders: State<List<Order>> = _orders

    init {
        fetchOrders()
    }

    private fun fetchOrders() {
        viewModelScope.launch {
            try {
                val token = "Bearer 49b70f996ffbb654be996f8604d118bfca7624ced27749df6f4fdcac30b7009da1ba63ef7d6b91c8ca814baf88955daba2804396ab3b8cd2c03b50a1f96ff330032d2fbc2238338b4f7e25bff9e852b002c26ecca02fbf1e8e261cf6e0cdb00c042e35b33f64dda3522c3178ba1edb22b9daba42b51c1c8355309fd475b5d92b" // Normally you get this token from your auth process

                val response = ApiClient.dwitchService.getOrders(token)
                Timber.d("$response")
                val orderList = response.data
                _orders.value = orderList


            } catch (e: Exception) {

                Timber.d("Error fetching orders: ${e.message}")
            }
        }
    }
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DwitchAppTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text(" Mes Commandes")
                    }
                }
            )
        }
    ) { innerPadding ->
        OrderList(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp)
                .fillMaxSize()
        )
    }
}


@Composable
fun OrderList(viewModel: OrdersViewModel = viewModel(), modifier: Modifier = Modifier) {

    val orders by viewModel.orders
    LazyColumn (modifier = modifier){
        items(orders) { order ->
            OrderItem(order, modifier = Modifier
                .padding(vertical = 10.dp)
            )
        }
    }
}

@Composable
fun OrderItem(order: Order, modifier: Modifier) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .shadow(4.dp, shape = RoundedCornerShape(15.dp))
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(8 .dp)) {
            OrderHeader(order)
            IngredientsList(order)
            ProgressBar(order)
            HorizontalDivider(thickness = 1.dp, color = OpenColors.yellow1)
            OrderFooter(order)
        }
    }
}




@Composable
fun IngredientsList(order: Order) {
    LazyRow{
        items(order.ingredients) { ingredient ->
            Surface(
                color = Colors(Color.parseColor(ingredient.getColor())),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 3.dp)
            ) {
                Row (modifier = Modifier
                    .padding(vertical = 3.dp, horizontal = 10.dp)
                ) {
                    Text(ingredient.getEmoji())
                    Text(ingredient.name)
                }
            }
        }
    }
}


@Composable
fun ProgressBar(order: Order) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(bottom = 10.dp)
            .fillMaxSize()
    ) {
        Text("Progression", fontSize = 13.sp, letterSpacing = 0.4.sp)
        LinearProgressIndicator(
            progress = order.progress/100f,
            color = OpenColors.yellow1,
            modifier = Modifier
                .height(8.dp)
                .width(220.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text("${order.progress}%", fontSize = 13.sp, letterSpacing = 0.4.sp)
    }
}

@Composable
fun OrderHeader(order: Order) {
    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row{
            Text("Le ${order.getFormatedPlacedAtDate()}  ", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        }
        Surface(
            shape = MaterialTheme.shapes.small,
        ) {
            Text(
                "${order.price}€",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(6.dp)

            )
        }
    }
}

@Composable
fun OrderFooter(order: Order) {
    Row(
        modifier = Modifier
            .padding(top = 15.dp)
    ) {
        Text("${order.store?.name} - ${order.store?.city} ${order.store?.zipCode}", fontWeight = FontWeight.SemiBold)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun OrderListPreview() {
    DwitchAppTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Row {
                            Text(" Mes Commandes")
                        }
                    }
                )
            }
        ) { innerPadding ->
            OrderList(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(10.dp)
                    .fillMaxSize()
            )
        }
    }
}