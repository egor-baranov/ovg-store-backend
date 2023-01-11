package com.kepler88d.models.product

import com.kepler88d.models.product.Product.Companion.referrersOn
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Images : IntIdTable() {
    val product = reference("product", Products)
    val url = varchar("url", 256)
}

class Image(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Image>(Images)

    var product by Product referencedOn Images.product
    var url by Images.url
}
