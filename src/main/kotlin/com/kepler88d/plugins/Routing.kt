package com.kepler88d.plugins

import com.kepler88d.models.Image
import com.kepler88d.models.Images
import com.kepler88d.models.Product
import com.kepler88d.models.ProductModel
import com.kepler88d.models.ProductModels
import com.kepler88d.models.response.ProductResponse
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun productResponse(id: String): ProductResponse {
    val product = Product.findById(id.toInt())!!
    val models = ProductModel.find { ProductModels.productId eq product.id.value }
    val images = Image.find { Images.productId eq product.id.value }

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

    }
}
