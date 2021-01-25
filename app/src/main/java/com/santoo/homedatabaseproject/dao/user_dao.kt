package com.santoo.homedatabaseproject.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.santoo.homedatabaseproject.entity.User

@Dao
interface user_dao
{

    @Insert
    suspend fun registerUser(user : User)

    @Query("select * from User where username=(:username) and password=(:password)")
    suspend fun checkUser(username: String, password: String): User
}