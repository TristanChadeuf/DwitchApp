package model

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class OrdersResponse(

    val data: List<Order>
)