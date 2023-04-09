package com.kepler88d.plugins

import com.kepler88d.models.product.Product
import com.kepler88d.models.response.ProductResponse
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import java.util.UUID

fun productResponse(id: String): ProductResponse? {
    val product = Product.findById(UUID.fromString(id)) ?: return null
    val models = product.models
    val images = product.images

   return ProductResponse(
        id = product.id.toString(),
        label = product.label,
        description = product.description,
        price = product.price.toString(),
        sizes = models.map { it.size },
        colors = models.map { it.color },
        images = images.map { it.url }
    )
}

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respond(HttpStatusCode.OK)
        }

    }
}
