package com.kepler88d.models.response

data class CategoriesResponse(
    val categories: Map<String, List<ProductResponse>>
)
