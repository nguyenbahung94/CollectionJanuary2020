package com.example.collectionjanuary2020.fullcorountines.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.collectionjanuary2020.fullcorountines.data.local.dao.UserDao
import com.example.collectionjanuary2020.fullcorountines.data.local.entity.User


@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}