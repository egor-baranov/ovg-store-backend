package com.kepler88d.models.product

import com.kepler88d.models.product.Product.Companion.backReferencedOn
import com.kepler88d.models.product.Product.Companion.referencedOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object ProductModels : IntIdTable() {
    val product = reference("product", Products)
    val color = varchar("url", 128)
    val size = varchar("url", 128)
    val amount = integer("amount")
}

class ProductModel(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ProductModel>(ProductModels)

    var product by Product referencedOn ProductModels.product
    var color by ProductModels.color
    var size by ProductModels.size
    var amount by ProductModels.amount
}
