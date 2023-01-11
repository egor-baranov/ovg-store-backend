package com.kepler88d.models.order

import com.kepler88d.models.product.ProductModel
import com.kepler88d.models.product.ProductModels
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object Orders: IntIdTable() {
    val model = reference("model", ProductModels)
    val client = varchar("client", 256)
    val price = double("price")
}

object OrderModels: Table() {
    val order = reference("order", Orders)
    val model = reference("model", ProductModels)

    override val primaryKey = PrimaryKey(order, model)
}

class Order(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Order>(Orders)

    var models by ProductModel via OrderModels
    var client by Orders.client
    var price by Orders.price
}
