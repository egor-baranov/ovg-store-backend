package com.kepler88d.plugins.routing

import com.kepler88d.models.order.Order
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import java.util.UUID

fun Application.orderRoutes() {
    routing {
        get("/order/{id}") {
            call.respondText {
                Order[UUID.fromString(call.parameters["id"])].toString()
            }
        }

        get("/order/list") {

        }

        post("/order/create") {

        }
    }
}
