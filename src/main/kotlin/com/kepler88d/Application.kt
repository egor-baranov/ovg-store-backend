package com.kepler88d

import com.kepler88d.factory.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.kepler88d.plugins.*
import com.kepler88d.plugins.routing.categoryRoutes
import com.kepler88d.plugins.routing.orderRoutes
import com.kepler88d.plugins.routing.productRoutes
import com.kepler88d.plugins.routing.searchRoutes
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import kotlinx.serialization.json.Json
import java.lang.System.getenv

open class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            embeddedServer(
                Netty,
                port = (getenv("PORT") ?: "8080").toInt(),
                host = "0.0.0.0", module = Application::module
            ).start(wait = true)
        }
    }
}

fun Application.module() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            isLenient = true
        })
    }

    DatabaseFactory.init()
    configureRouting()

    categoryRoutes()
    orderRoutes()
    productRoutes()
    searchRoutes()
}
