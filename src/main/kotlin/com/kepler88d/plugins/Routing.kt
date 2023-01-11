package com.kepler88d.plugins

import com.kepler88d.models.product.Image
import com.kepler88d.models.product.Images
import com.kepler88d.models.product.Product
import com.kepler88d.models.product.ProductModel
import com.kepler88d.models.product.ProductModels
import com.kepler88d.models.product.ProductModels.entityId
import com.kepler88d.models.response.ProductResponse
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun productResponse(id: String): ProductResponse? {
    val product = Product.findById(id.toInt()) ?: return null
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
        get("/product/{id}") {

            call.respondText {
                ProductResponse(
                    id = "id",
                    label = "Adidas x Pharrell Williams Basics Hoodie",
                    description = "description",
                    price = "7490",
                    sizes = listOf("S", "M", "L", "XL", "2XL"),
                    colors = listOf("Черный", "Белый", "Серый", "Бежевый"),
                    images = listOf("https://storage.yandexcloud.net/ovg-store/img-2.jpg"),
                ).toString()
            }
        }

        get("/order/all") {

        }
    }
}
