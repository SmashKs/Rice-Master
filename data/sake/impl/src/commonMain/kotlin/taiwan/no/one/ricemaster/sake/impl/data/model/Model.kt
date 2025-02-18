package taiwan.no.one.ricemaster.sake.impl.data.model

import taiwan.no.one.ricemaster.sake.api.entity.Entity

internal interface Model {
    fun toEntity(): Entity
}
