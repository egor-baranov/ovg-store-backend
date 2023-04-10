package com.kepler88d.plugins.routing

import com.kepler88d.models.response.CategoriesResponse
import com.kepler88d.models.response.DEFAULT_PRODUCT_RESPONSE
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.categoryRoutes() {
    routing {
        get("/category/list") {
            call.respondText {
                CategoriesResponse(
                    categories = mapOf(
                        "Футболки" to listOf(DEFAULT_PRODUCT_RESPONSE)
                    )
                ).toString()
            }
        }
    }
}
