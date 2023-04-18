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
        fun default(id: String = "id") = ProductResponse(
            id = id,
            label = "Product $id",
            description = "description",
            price = ((20..90).random() * 100 + 90).toString(),
            sizes = listOf("S", "M", "L", "XL", "2XL"),
            colors = listOf("Черный", "Белый", "Серый", "Бежевый"),
            images = (3..6).random().let { 0 until it }.map { "https://storage.yandexcloud.net/ovg-store/img-2.jpg" },
        )
    }
}
