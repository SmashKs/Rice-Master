package taiwan.no.one.ricemaster.sake.api

import taiwan.no.one.ricemaster.sake.api.entity.SakeDetailEntity
import taiwan.no.one.ricemaster.sake.api.entity.SakeEntity

interface SakeRepo {
    suspend fun init() // need to be removed

    suspend fun getSake(): SakeEntity

    suspend fun getSakeDetail(id: Long): SakeDetailEntity
}
