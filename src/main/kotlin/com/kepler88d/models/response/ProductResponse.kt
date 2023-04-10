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
        private var id = 0
         fun default() = ProductResponse(
            id = (id++).toString(),
            label = "Product №$id",
            description = "description",
            price = ((20..90).random() * 100 + 90).toString(),
            sizes = listOf("S", "M", "L", "XL", "2XL"),
            colors = listOf("Черный", "Белый", "Серый", "Бежевый"),
            images = listOf("https://storage.yandexcloud.net/ovg-store/img-2.jpg"),
        )
    }
}
