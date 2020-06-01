package com.example.collectionjanuary2020.fullcorountines.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.collectionjanuary2020.fullcorountines.data.local.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(users: List<User>)

    @Delete
    suspend fun delete(user: User)

}