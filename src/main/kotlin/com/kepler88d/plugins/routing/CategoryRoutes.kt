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

fun Application.categoryRoutes() {
    routing {
        get("/category/all") {
            call.respondText {
                Json.encodeToString(
                    CategoriesResponse(
                        categories = mapOf(
                            "Футболки" to listOf(ProductResponse.DEFAULT)
                        )
                    )
                )
            }
        }
    }
}
