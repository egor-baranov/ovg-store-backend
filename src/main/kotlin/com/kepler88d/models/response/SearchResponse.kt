package com.kepler88d.models.response

import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    val items: List<ProductResponse>
) {
    companion object {
        fun default(query: String) = SearchResponse(
            items = (3..6).random().let { 0 until it }.map { ProductResponse.default() }
        )
    }
}
