package com.kepler88d.models

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*

object Products : IntIdTable() {
    val productId = integer("product_id").uniqueIndex()
    val label = varchar("label", 128)
    val description = varchar("description", 1024)
    val price = float("price")
}

class Product(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Product>(Products)

    var label by Products.label
    var description by Products.description
    var price by Products.price
}
