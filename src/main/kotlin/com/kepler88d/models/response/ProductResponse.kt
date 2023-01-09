package com.kepler88d.models.response

data class ProductResponse(
    val id: String,
    val label: String,
    val description: String,
    val price: String,
    val sizes: List<String>,
    val colors: List<String>,
    val images: List<String>
)
