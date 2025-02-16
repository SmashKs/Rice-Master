package taiwan.no.one.ricemaster.impl.sake.data.model

import taiwan.no.one.ricemaster.sake.api.entity.Entity

internal interface Model {
    fun toEntity(): Entity
}
