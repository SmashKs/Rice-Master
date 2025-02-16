package taiwan.no.one.ricemaster.impl.sake.data.repository

import org.koin.core.annotation.Factory
import org.koin.core.annotation.Provided
import taiwan.no.one.ricemaster.impl.sake.data.SakeDatabase
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.compose.SakeDetailModel
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeAromaCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeAwardCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeFlavorCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.provider.parseSakeDataJson
import taiwan.no.one.ricemaster.sake.api.SakeRepo
import taiwan.no.one.ricemaster.sake.api.entity.SakeDetailEntity
import taiwan.no.one.ricemaster.sake.api.entity.SakeEntity

@Factory
internal class SakeRepository(
    @Provided private val sakeDatabase: SakeDatabase,
) : SakeRepo {
    override suspend fun init() {
        val sakeData = parseSakeDataJson()

        sakeDatabase.speciallyDesignatedSakeDao().insert(*sakeData.speciallyDesignatedSakes.toTypedArray())
        sakeDatabase.sakeAwardDao().insert(*sakeData.awards.toTypedArray())
        sakeDatabase.sakeImageDao().insert(*sakeData.images.toTypedArray())
        sakeDatabase.breweryDao().insert(*sakeData.breweries.toTypedArray())
        sakeDatabase.aromaProfileDao().insert(*sakeData.aromaProfiles.toTypedArray())
        sakeDatabase.flavorProfileDao().insert(*sakeData.flavorProfiles.toTypedArray())
        sakeDatabase.sakeDao().insert(*sakeData.sakes.toTypedArray())
        sakeData.sakes.forEach { sakeModel ->
            sakeModel.aromaIds.forEach {
                sakeDatabase.sakeDao().insertSakeAromaCrossRef(SakeAromaCrossRef(sakeModel.sakeId, it))
            }
            sakeModel.awardIds.forEach {
                sakeDatabase.sakeDao().insertSakeAwardCrossRef(SakeAwardCrossRef(sakeModel.sakeId, it))
            }
            sakeModel.flavorIds.forEach {
                sakeDatabase.sakeDao().insertSakeFlavorCrossRef(SakeFlavorCrossRef(sakeModel.sakeId, it))
            }
        }
    }

    override suspend fun getSake(): SakeEntity = requireNotNull(
        sakeDatabase.sakeDao()
            .getSakeById(1)
            ?.run(SakeModel::toEntity),
    )

    override suspend fun getSakeDetail(id: Long): SakeDetailEntity =
        sakeDatabase.sakeDao().getDetailedSake(id).run(SakeDetailModel::toEntity)
}
