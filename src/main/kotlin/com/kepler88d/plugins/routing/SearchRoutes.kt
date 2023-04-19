package com.kepler88d.plugins.routing

import com.kepler88d.models.response.SearchResponse
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.util.getOrFail
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Application.searchRoutes() {
    routing {
        get("/search/{query}") {
            call.respondText {
                Json.encodeToString(
                    SearchResponse.default(
                        query = call.parameters.getOrFail<String>("query")
                    )
                )
            }
        }
    }
}
