package com.kepler88d.models.product

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.UUID

object ProductModels : UUIDTable() {
    val product = reference("product", Products)
    val color = varchar("url", 128)
    val size = varchar("url", 128)
    val amount = integer("amount")
}

class ProductModel(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<ProductModel>(ProductModels)

    var product by Product referencedOn ProductModels.product
    var color by ProductModels.color
    var size by ProductModels.size
    var amount by ProductModels.amount
}
