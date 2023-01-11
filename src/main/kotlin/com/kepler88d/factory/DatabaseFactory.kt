package com.kepler88d.factory

import com.kepler88d.models.product.Images
import com.kepler88d.models.product.Products
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils.create as create
import org.jetbrains.exposed.sql.transactions.*

object DatabaseFactory {
    fun init() {
        val driverClassName = "org.h2.Driver"
        val jdbcURL = "jdbc:h2:file:./build/db"

        val database = Database.connect(jdbcURL, driverClassName)
        transaction(database) {
            create(Products)
            create(Images)
        }
    }
}
