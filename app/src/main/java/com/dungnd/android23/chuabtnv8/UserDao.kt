package com.dungnd.android23.chuabtnv8

import androidx.room.*

@Dao
interface UserDao {
    //Lấy tất cả dữ liệu user đã lưu ở trong database và sắp xếp lại
    @Query("SELECT * FROM user ORDER BY id DESC")
    fun getAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Query("DELETE FROM user")
    fun deleteAll()
}