package com.example.dwitchapp
import android.graphics.ColorSpace
import android.graphics.ColorSpace.Rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.pm.ShortcutInfoCompat
import com.example.dwitchapp.ui.theme.DwitchAppTheme
import com.example.dwitchapp.ui.theme.OpenColors
import data.ingredients
import data.orders
import model.Ingredient
import model.Order


class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DwitchAppTheme {

                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("Mes Commandes")
                            }

                        )
                    },
                ) { innerPadding->
                    ListOrder(modifier = Modifier.padding(innerPadding))

                }
                }
            }
        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DwitchAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Mes Commandes")
                    }

                )
            },
        ) { innerPadding->
            ListOrder(modifier = Modifier.padding(innerPadding))

        }

    }
}

@Composable
fun ListOrder(modifier: Modifier){
    LazyColumn(modifier = modifier) {

        items(orders) { order ->
            Surface (modifier = Modifier
                .padding(15.dp),
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 10.dp,
                color = OpenColors.gray2
            ) {
                Column(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(),

                    horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Bottom
                ) {
                    DatePrice(order)
                    Text(text = "Client : ${order.usersPermissionsUser.username}")
                    Text(text = order.store.name)
                    ListIngredient()
                    Text(text = order.cookMessage)
                    LinearProgressIndicator(
                            progress = { 0.7F},
                    modifier = Modifier.fillMaxWidth(),
                    )

                }

            }
        }

    }
}

@Composable
fun DatePrice(order: Order) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
            )
            {

                Text(text = "Le ${order.publishedAt}")
                Text(text = "${order.price}€")
            }
        }

@Composable
fun ListIngredient() {
    LazyRow() {
    items(ingredients) { ingredient ->
        Surface(
            color = OpenColors.red3,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .shadow(4.dp, shape = RoundedCornerShape(15.dp))

        ){
            Row(modifier = Modifier.padding(5.dp)) {
                Text(text = ingredient.name)
                Text(text = ingredient.getEmoji())
            }
        }

    }
    }
}