package com.example.tuananh

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(FolderModel::class), version = 2)
public abstract class Sqlite: RoomDatabase() {

    abstract fun folderitemDao(): FolderDao

    companion object {

        @Volatile
        private var INSTANCE: Sqlite? = null

        fun getDatabase(context: Context): Sqlite {
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

        private fun buildDatabase(context: Context): Sqlite {
            return Room.databaseBuilder(
                context.applicationContext,
                Sqlite::class.java,
                "notes_database"
            ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
        }
    }
}