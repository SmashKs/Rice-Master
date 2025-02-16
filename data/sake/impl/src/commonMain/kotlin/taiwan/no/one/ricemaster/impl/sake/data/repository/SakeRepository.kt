package taiwan.no.one.ricemaster.impl.sake.data.repository

import kotlinx.datetime.Clock
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase
import taiwan.no.one.ricemaster.impl.sake.data.provider.parseJson
import taiwan.no.one.ricemaster.sake.api.SakeRepo
import taiwan.no.one.ricemaster.sake.api.entity.AromaProfileEntity
import taiwan.no.one.ricemaster.sake.api.entity.AwardEntity
import taiwan.no.one.ricemaster.sake.api.entity.BreweryEntity
import taiwan.no.one.ricemaster.sake.api.entity.FlavorProfileEntity
import taiwan.no.one.ricemaster.sake.api.entity.ImageEntity
import taiwan.no.one.ricemaster.sake.api.entity.SakeDetailEntity
import taiwan.no.one.ricemaster.sake.api.entity.SakeEntity
import taiwan.no.one.ricemaster.sake.api.entity.SpeciallyDesignatedSakeEntity

@Factory
internal class SakeRepository(
    @Provided private val sakeDatabase: SakeDatabase,
) : SakeRepo {
    override suspend fun init() {
//        println("1111111111111111111111111")
//        sakeDatabase.speciallyDesignatedSakeDao().insert(*ProvideFakeData.speciallyDesignatedSakes.toTypedArray())
//        println("2222222222222222222222222")
//        sakeDatabase.sakeAwardDao().insert(*ProvideFakeData.awards.toTypedArray())
//        println("3333333333333333333333333")
//        sakeDatabase.sakeImageDao().insert(*ProvideFakeData.images.toTypedArray())
//        println("4444444444444444444444444")
//        sakeDatabase.breweryDao().insert(*ProvideFakeData.breweries.toTypedArray())
//        println("5555555555555555555555555")
//        sakeDatabase.aromaProfileDao().insert(*ProvideFakeData.aromaProfiles.toTypedArray())
//        println("6666666666666666666666666")
//        sakeDatabase.flavorProfileDao().insert(*ProvideFakeData.flavorProfiles.toTypedArray())
//        println("7777777777777777777777777")
//        sakeDatabase.sakeDao().insert(*ProvideFakeData.sakes.toTypedArray())
//        println("8888888888888888888888888")
//        ProvideFakeData.sakes.forEach { sakeModel ->
//            sakeModel.aromaIds.forEach {
//                sakeDatabase.sakeDao().insertSakeAromaCrossRef(SakeAromaCrossRef(sakeModel.sakeId, it))
//            }
//            sakeModel.awardIds.forEach {
//                sakeDatabase.sakeDao().insertSakeAwardCrossRef(SakeAwardCrossRef(sakeModel.sakeId, it))
//            }
//            sakeModel.flavorIds.forEach {
//                sakeDatabase.sakeDao().insertSakeFlavorCrossRef(SakeFlavorCrossRef(sakeModel.sakeId, it))
//            }
//        }
//        println("9999999999999999999999999")
        println(parseJson())
    }

    override suspend fun getSake(): SakeEntity = sakeDatabase.sakeDao()
        .getSakeById(1)
        ?.run {
            SakeEntity(
                id = sakeId,
                name = name,
                abv = abv,
                polishingRatio = polishingRatio,
                brewDate = brewDate ?: Clock.System.now(),
                expirationDate = expirationDate ?: Clock.System.now(),
                priceRange = priceRange.orEmpty(),
                description = description.orEmpty(),
            )
        }!!

    override suspend fun getSakeDetail(id: Long): SakeDetailEntity {
        return sakeDatabase.sakeDao().getDetailedSake(id).run {
            SakeDetailEntity(
                sake = SakeEntity(
                    id = id,
                    name = sake.name,
                    abv = sake.abv,
                    polishingRatio = sake.polishingRatio,
                    brewDate = sake.brewDate ?: Clock.System.now(),
                    expirationDate = sake.expirationDate ?: Clock.System.now(),
                    priceRange = sake.priceRange.orEmpty(),
                    description = sake.description.orEmpty(),
                ),
                brewery = BreweryEntity(
                    id = brewery.breweryId,
                    name = brewery.name,
                    location = brewery.location,
                    description = brewery.description.orEmpty(),
                    website = brewery.website.orEmpty(),
                ),
                speciallyDesignatedSake = SpeciallyDesignatedSakeEntity(
                    id = speciallyDesignatedSake.speciallyDesignatedSakeId,
                    name = speciallyDesignatedSake.name,
                    description = speciallyDesignatedSake.description.orEmpty(),
                ),
                images = images.map {
                    ImageEntity(
                        id = it.imageId,
                        imageUrl = it.imageUrl,
                        description = it.description,
                    )
                },
                flavorProfiles = flavorProfiles.map {
                    FlavorProfileEntity(
                        id = it.flavorProfileId,
                        name = it.name,
                        description = it.description,
                    )
                },
                aromaProfiles = aromaProfiles.map {
                    AromaProfileEntity(
                        id = it.aromaProfileId,
                        name = it.name,
                        description = it.description.orEmpty(),
                    )
                },
                awards = awards.map {
                    AwardEntity(
                        id = it.awardId,
                        awardName = it.name,
                        year = it.year,
                    )
                },
            )
        }
    }
}
