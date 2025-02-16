package taiwan.no.one.ricemaster.impl.sake.data.repository

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase
import taiwan.no.one.ricemaster.impl.sake.data.provider.ProvideFakeData
import taiwan.no.one.ricemaster.sake.api.SakeRepo
import taiwan.no.one.ricemaster.sake.api.entity.SakeEntity

@Factory
internal class SakeRepository(
    @Provided private val sakeDatabase: SakeDatabase,
) : SakeRepo {
    override suspend fun init() {
        println("1111111111111111111111111")
        sakeDatabase.speciallyDesignatedSakeDao().insert(*ProvideFakeData.speciallyDesignatedSakes.toTypedArray())
        println("2222222222222222222222222")
        sakeDatabase.sakeAwardDao().insert(*ProvideFakeData.awards.toTypedArray())
        println("3333333333333333333333333")
        sakeDatabase.sakeImageDao().insert(*ProvideFakeData.images.toTypedArray())
        println("4444444444444444444444444")
        sakeDatabase.breweryDao().insert(*ProvideFakeData.breweries.toTypedArray())
        println("5555555555555555555555555")
        sakeDatabase.aromaProfileDao().insert(*ProvideFakeData.aromaProfiles.toTypedArray())
        println("6666666666666666666666666")
        sakeDatabase.flavorProfileDao().insert(*ProvideFakeData.flavorProfiles.toTypedArray())
        println("7777777777777777777777777")
        sakeDatabase.sakeDao().insert(*ProvideFakeData.sakes.toTypedArray())
        println("8888888888888888888888888")
    }

    override suspend fun getSake(): SakeEntity = sakeDatabase.sakeDao()
        .getSakeById(1)
        ?.run {
            SakeEntity(
                id = id,
                name = name,
                abv = abv,
                polishingRatio = polishingRatio,
                brewDate = brewDate,
                expirationDate = expirationDate,
                priceRange = priceRange,
                imageUrl = imageUrl,
                description = description,
            )
        }!!
}
