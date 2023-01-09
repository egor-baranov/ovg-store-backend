package com.kepler88d.models

import com.kepler88d.models.Images.uniqueIndex
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object ProductModels : IntIdTable() {
    val productId = integer("product_id").uniqueIndex()
    val color = varchar("url", 128)
    val size = varchar("url", 128)
    val amount = integer("amount")
}

class ProductModel(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ProductModel>(ProductModels)

    var productId by ProductModels.productId
    var color by ProductModels.color
    var size by ProductModels.size
    var amount by ProductModels.amount
}
