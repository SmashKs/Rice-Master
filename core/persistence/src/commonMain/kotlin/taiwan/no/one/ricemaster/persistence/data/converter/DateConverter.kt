package taiwan.no.one.ricemaster.persistence.data.converter

import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import kotlinx.datetime.Instant.Companion

class DateConverter {
    @TypeConverter
    fun fromInstant(instant: Instant?): Long? = instant?.epochSeconds

    @TypeConverter
    fun toInstant(value: Long?): Instant? = value?.let(Companion::fromEpochSeconds)
}
