package com.example.tuananh

import androidx.room.*

@Dao
interface FolderDao {
    @Query("SELECT * FROM folder ORDER BY id ASC")
    fun getAllFolder(): List<FolderModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: FolderModel)

    @Update
    fun update(user: FolderModel)

    @Query("DELETE FROM folder")
    fun deleteAll()
}