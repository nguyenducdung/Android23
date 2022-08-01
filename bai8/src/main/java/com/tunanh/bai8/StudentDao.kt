package com.tunanh.bai8

import androidx.room.*

@Dao
interface StudentDao {
    @Query("SELECT * FROM folder ORDER BY id DESC")
    fun getAllFolder(): List<StudentModel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: StudentModel)

    @Update
    fun update(user: StudentModel)

    @Query("DELETE FROM folder")
    fun deleteAll()
}