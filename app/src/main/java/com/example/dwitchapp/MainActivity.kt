package com.example.dwitchapp
import View.HomeScreen
import View.NewsScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dwitchapp.service.ApiClient
import com.example.dwitchapp.ui.theme.DwitchAppTheme
import View.OrderScreen
import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import model.Order
import timber.log.Timber
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import model.Color
import java.lang.reflect.Modifier
import kotlin.math.roundToInt


class OrdersViewModel : ViewModel() {
    private val _orders = mutableStateOf<List<Order>>(emptyList())
    val orders: State<List<Order>> = _orders

    init {
        fetchOrders()
    }

    private fun fetchOrders() {
        viewModelScope.launch {
            try {
                val token = "Bearer 49b70f996ffbb654be996f8604d118bfca7624ced27749df6f4f" +
                        "dcac30b7009da1ba63ef7d6b91c8ca814baf88955daba2804396ab3b8cd2c03b5" +
                        "0a1f96ff330032d2fbc2238338b4f7e25bff9e852b002c26ecca02fbf1e8e261cf6" +
                        "e0cdb00c042e35b33f64dda3522c3178ba1edb22b9daba42b51c1c8355309fd475b5d92b" // Normally you get this token from your auth process

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
//**************************************************************************************************
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DwitchAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar {
                            var selectedItem by remember { mutableIntStateOf(1) }
                            val items = listOf("Home", "Orders", "News")
                            val selectedIcons = listOf(Icons.Filled.Home, Icons.Filled.Favorite, Icons.Filled.Star)
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        icon = {
                                            Icon(
                                                selectedIcons[index],
                                                contentDescription = item
                                            )
                                        },
                                        label = { Text(item) },
                                        selected = selectedItem == index,
                                        onClick = {
                                            selectedItem = index
                                            navController.navigate(item)
                                        }
                                    )
                                }
                            }
                        }
                    }
                ){
                    NavHost(
                        navController = navController,
                        startDestination = "Orders"
                    ) {
                        composable(route = "Home") {
                            HomeScreen()
                        }
                        composable(route = "Orders") {
                            OrderScreen()
                        }
                        composable(route = "News") {
                            NewsScreen()
                        }
                    }
                }
            }
        }
    }
}


//REFRESH*******************************************************************************************


//PREVIEW*******************************************************************************************
@Preview(showBackground = true)
@Composable
fun OrderListPreview() {
            DwitchAppTheme {
                OrderScreen()
            }
        }

