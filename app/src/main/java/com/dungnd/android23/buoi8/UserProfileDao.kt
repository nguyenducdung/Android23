package com.dungnd.android23.buoi8

import androidx.room.*

//Mục đích là query và cập nhật dữ liệu
@Dao
interface UserProfileDao {
    //Lấy tất cả dữ liệu user đã lưu ở trong database và sắp xếp lại
    @Query("SELECT * FROM user_profile ORDER BY id ASC")
    fun getAllUser(): List<UserProfile>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: UserProfile)

    @Update
    fun update(user: UserProfile)

    @Query("DELETE FROM user_profile")
    fun deleteAll()
}