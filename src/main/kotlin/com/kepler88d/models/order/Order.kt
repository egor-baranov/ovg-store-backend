package com.kepler88d.models.order

import com.kepler88d.models.product.ProductModel
import com.kepler88d.models.product.ProductModels
import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Orders: UUIDTable() {
    val model = reference("model", ProductModels)
    val client = varchar("client", 256)
    val price = double("price")
}

object OrderModels: Table() {
    val order = reference("order", Orders)
    val model = reference("model", ProductModels)

    override val primaryKey = PrimaryKey(order, model)
}

class Order(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<Order>(Orders)

    var models by ProductModel via OrderModels
    var client by Orders.client
    var price by Orders.price
}
