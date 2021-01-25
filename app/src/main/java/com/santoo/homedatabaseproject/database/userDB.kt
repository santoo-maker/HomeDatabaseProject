package com.santoo.homedatabaseproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.santoo.homedatabaseproject.dao.StudentDAO
import com.santoo.homedatabaseproject.dao.user_dao
import com.santoo.homedatabaseproject.entity.User

@Database(
    entities = [(User::class)],
    version = 1
)
abstract class userDB : RoomDatabase() {
    abstract fun getStudentDAO(): StudentDAO

    abstract fun getUserDAO(): user_dao
    companion object {
        @Volatile
        private var instance: userDB? = null
        fun getInstance(context: Context): userDB {
            if (instance == null) {
                synchronized(userDB::class) {
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                userDB::class.java,
                "StudentDB"
            ).build()
    }
}