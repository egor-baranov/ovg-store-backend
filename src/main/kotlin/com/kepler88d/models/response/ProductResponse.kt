package com.kepler88d.models.response

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse(
    val id: String,
    val label: String,
    val description: String,
    val price: String,
    val sizes: List<String>,
    val colors: List<String>,
    val images: List<String>
) {
    companion object {
        val DEFAULT = ProductResponse(
            id = "0",
            label = "Adidas x Pharrell Williams Basics Hoodie",
            description = "description",
            price = "7490",
            sizes = listOf("S", "M", "L", "XL", "2XL"),
            colors = listOf("Черный", "Белый", "Серый", "Бежевый"),
            images = listOf("https://storage.yandexcloud.net/ovg-store/img-2.jpg"),
        )
    }
}
