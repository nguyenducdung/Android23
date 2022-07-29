package com.dungnd.android23.buoi8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(UserProfile::class), version = 1)
public abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun userProfileDao(): UserProfileDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(context: Context): AppRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            if (INSTANCE == null) {
                synchronized(this) {
                    // Pass the database to the INSTANCE
                    INSTANCE = buildDatabase(context)
                }
            }
            // Return database.
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): AppRoomDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "notes_database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}