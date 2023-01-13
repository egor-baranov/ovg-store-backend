package com.kepler88d

import com.kepler88d.factory.DatabaseFactory
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.kepler88d.plugins.*
import java.lang.System.getenv

fun main() {
    embeddedServer(
        Netty,
        port = (getenv("PORT") ?: "8080").toInt(),
        host = "0.0.0.0", module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    configureRouting()
}
