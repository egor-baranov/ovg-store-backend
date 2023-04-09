package com.kepler88d.models.product

import org.jetbrains.exposed.dao.UUIDEntity
import org.jetbrains.exposed.dao.UUIDEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.UUIDTable
import java.util.UUID

object Images : UUIDTable() {
    val product = reference("product", Products)
    val url = varchar("url", 256)
}

class Image(id: EntityID<UUID>): UUIDEntity(id) {
    companion object: UUIDEntityClass<Image>(Images)

    var product by Product referencedOn Images.product
    var url by Images.url
}
