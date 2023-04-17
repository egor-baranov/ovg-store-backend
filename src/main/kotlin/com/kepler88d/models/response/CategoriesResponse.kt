package com.kepler88d.models.response

import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponse(
    val categories: Map<String, List<ProductResponse>>,
    val titleIds: Map<String, String>
)
