package taiwan.no.one.ricemaster.impl.sake.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import taiwan.no.one.ricemaster.impl.sake.data.model.AromaProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.AwardModel
import taiwan.no.one.ricemaster.impl.sake.data.model.BreweryModel
import taiwan.no.one.ricemaster.impl.sake.data.model.FlavorProfileModel
import taiwan.no.one.ricemaster.impl.sake.data.model.ImageModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.SpeciallyDesignatedSakeModel
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeAromaCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeAwardCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.model.relation.SakeFlavorCrossRef
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.AromaProfileDao
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.BreweryDao
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.FlavorProfileDao
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.SakeAwardDao
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.SakeDao
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.SakeImageDao
import taiwan.no.one.ricemaster.impl.sake.data.repository.store.local.SpeciallyDesignatedSakeDao
import taiwan.no.one.ricemaster.persistence.data.converter.DateConverter

@Database(
    entities = [
        AromaProfileModel::class,
        BreweryModel::class,
        FlavorProfileModel::class,
        SakeModel::class,
        AwardModel::class,
        ImageModel::class,
        SpeciallyDesignatedSakeModel::class,
        SakeAromaCrossRef::class,
        SakeAwardCrossRef::class,
        SakeFlavorCrossRef::class,
    ],
    version = 1, // Update the version if you add/change database schema in the future
    exportSchema = false, // Use true if you want to export the schema, generally used in production
)
@TypeConverters(DateConverter::class)
@ConstructedBy(SakeDatabaseConstructor::class)
internal abstract class SakeDatabase : RoomDatabase() {
    abstract fun breweryDao(): BreweryDao

    abstract fun speciallyDesignatedSakeDao(): SpeciallyDesignatedSakeDao

    abstract fun sakeDao(): SakeDao

    abstract fun flavorProfileDao(): FlavorProfileDao

    abstract fun aromaProfileDao(): AromaProfileDao

    abstract fun sakeImageDao(): SakeImageDao

    abstract fun sakeAwardDao(): SakeAwardDao
}

// Room compiler generates the `actual` implementations
@Suppress("NO_ACTUAL_FOR_EXPECT")
internal expect object SakeDatabaseConstructor : RoomDatabaseConstructor<SakeDatabase> {
    override fun initialize(): SakeDatabase
}
