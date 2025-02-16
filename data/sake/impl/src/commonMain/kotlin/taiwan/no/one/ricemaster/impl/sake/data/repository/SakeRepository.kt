package taiwan.no.one.ricemaster.impl.sake.data.repository

import org.koin.core.annotation.Factory
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase
import taiwan.no.one.ricemaster.sake.api.SakeRepo

@Factory
internal class SakeRepository(
    sakeDatabase: SakeDatabase,
) : SakeRepo
