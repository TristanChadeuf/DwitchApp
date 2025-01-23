package Composable

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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dwitchapp.OrdersViewModel
import com.example.dwitchapp.ui.theme.OpenColors
import model.Order


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
//**********************************************************************************************

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
            HorizontalDivider(thickness = 1.dp, color = OpenColors.blue3)
            OrderFooter(order)
        }
    }
}

//**********************************************************************************************
@Composable
fun IngredientsList(order: Order) {
    LazyRow{
        items(order.ingredients) { ingredient ->
            Surface(
                color = Color(android.graphics.Color.parseColor(ingredient.getColor())),
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
//**********************************************************************************************
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
            color = OpenColors.blue3,
            modifier = Modifier
                .height(8.dp)
                .width(220.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text("${order.progress}%", fontSize = 13.sp, letterSpacing = 0.4.sp)
    }
}
//**********************************************************************************************
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
//**********************************************************************************************
@Composable
fun OrderFooter(order: Order) {
    Row(
        modifier = Modifier
            .padding(top = 15.dp)
    ) {
        Text("${order.store?.name} - ${order.store?.city} ${order.store?.zipCode}", fontWeight = FontWeight.SemiBold)
    }
}