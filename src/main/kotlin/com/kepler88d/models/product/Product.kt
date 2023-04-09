package com.kepler88d.models.product

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.UUID

object Products : UUIDTable() {
    val label = varchar("label", 128)
    val description = varchar("description", 1024)
    val price = float("price")
}

class Product(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<Product>(Products)

    var label by Products.label
    var description by Products.description
    var price by Products.price

    val models by ProductModel referrersOn ProductModels.product
    val images by Image referrersOn Images.product
}
