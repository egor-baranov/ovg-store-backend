package com.kepler88d.plugins.routing

import com.kepler88d.models.response.ProductResponse
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing

fun Application.productRoutes() {
    routing {
        get("/product/{id}") {
            call.respond {
                ProductResponse.DEFAULT
            }
        }
    }
}