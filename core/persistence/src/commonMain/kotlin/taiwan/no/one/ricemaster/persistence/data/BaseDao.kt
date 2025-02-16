package taiwan.no.one.ricemaster.persistence.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

/**
 * Integrated the base [androidx.room.Room] database operations. Thru [androidx.room.Room] we can just define the
 * interfaces that we want to access for from a local database. Using prefix name (get), (insert), (update), (delete)
 */
interface BaseDao<in T> {
    /**
     * Insert an object in the database.
     *
     * @param obj the object to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(obj: T): Long

    /**
     * Insert an array of objects in the database.
     *
     * @param obj the objects to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg obj: T)

    /**
     * Update an object from the database.
     *
     * @param obj the object to be updated.
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(obj: T)

    /**
     * Update an array of objects from the database.
     *
     * @param obj the object to be updated.
     */
    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg obj: T)

    /**
     * Delete an object from the database.
     *
     * @param obj the object to be deleted.
     */
    @Delete
    suspend fun delete(obj: T)

    /**
     * Delete an array of objects from the database.
     *
     * @param obj the object to be deleted.
     */
    @Delete
    suspend fun delete(vararg obj: T)
}
