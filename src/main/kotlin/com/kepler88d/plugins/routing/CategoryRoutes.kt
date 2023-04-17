package com.kepler88d.plugins.routing

import com.kepler88d.models.response.CategoriesResponse
import com.kepler88d.models.response.ProductResponse
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val CATEGORIES = mapOf(
    "Футболки" to "shirts",
    "Толстовки" to "hoodies",
    "Аксессуары" to "accessories",
    "Скидки" to "sales"
)

fun Application.categoryRoutes() {

    val categoriesResponse = Json.encodeToString(
        CategoriesResponse(
            categories = CATEGORIES.entries.associate { entry ->
                entry.key to (0..4).map {
                    ProductResponse.default(id = "${entry.value}$it")
                }
            },
            titleIds = CATEGORIES
        )
    )

    routing {
        get("/category/all") {
            call.respondText {
                categoriesResponse
            }
        }
    }
}
