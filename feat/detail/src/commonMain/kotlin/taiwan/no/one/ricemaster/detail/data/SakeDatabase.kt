package taiwan.no.one.ricemaster.detail.data

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import taiwan.no.one.ricemaster.detail.data.model.AromaProfile
import taiwan.no.one.ricemaster.detail.data.model.Brewery
import taiwan.no.one.ricemaster.detail.data.model.FlavorProfile
import taiwan.no.one.ricemaster.detail.data.model.Sake
import taiwan.no.one.ricemaster.detail.data.model.SpeciallyDesignatedSake
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeAroma
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeAward
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeFlavor
import taiwan.no.one.ricemaster.detail.data.model.compose.SakeImage
import taiwan.no.one.ricemaster.detail.data.repository.store.local.AromaProfileDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.BreweryDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.FlavorProfileDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.SakeAromaDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.SakeAwardDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.SakeDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.SakeFlavorDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.SakeImageDao
import taiwan.no.one.ricemaster.detail.data.repository.store.local.SpeciallyDesignatedSakeDao

@Database(
    entities = [
        AromaProfile::class,
        Brewery::class,
        FlavorProfile::class,
        Sake::class,
        SakeAroma::class,
        SakeAward::class,
        SakeFlavor::class,
        SakeImage::class,
        SpeciallyDesignatedSake::class,
    ],
    version = 1, // Update the version if you add/change database schema in the future
    exportSchema = false, // Use true if you want to export the schema, generally used in production
)
@ConstructedBy(SakeDatabaseConstructor::class)
abstract class SakeDatabase : RoomDatabase() {
    abstract fun breweryDao(): BreweryDao

    abstract fun speciallyDesignatedSakeDao(): SpeciallyDesignatedSakeDao

    abstract fun sakeDao(): SakeDao

    abstract fun flavorProfileDao(): FlavorProfileDao

    abstract fun sakeFlavorDao(): SakeFlavorDao

    abstract fun aromaProfileDao(): AromaProfileDao

    abstract fun sakeAromaDao(): SakeAromaDao

    abstract fun sakeImageDao(): SakeImageDao

    abstract fun sakeAwardDao(): SakeAwardDao
}

// Room compiler generates the `actual` implementations
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object SakeDatabaseConstructor : RoomDatabaseConstructor<SakeDatabase> {
    override fun initialize(): SakeDatabase
}
