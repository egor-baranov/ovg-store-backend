package com.kepler88d.models

import com.kepler88d.models.Products.uniqueIndex
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object Images : IntIdTable() {
    val productId = integer("product_id").uniqueIndex()
    val color = varchar("color", 128)
    val url = varchar("url", 256)
}

class Image(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<Image>(Images)

    var productId by Images.productId
    var color by Images.color
    var url by Images.url
}
