package com.dungnd.android23.buoi8

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfile(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "high")
    val high: String,
    @ColumnInfo(name = "weight")
    val weight: String
)
