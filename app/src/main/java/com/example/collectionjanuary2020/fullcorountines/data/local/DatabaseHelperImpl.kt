package com.example.collectionjanuary2020.fullcorountines.data.local

import com.example.collectionjanuary2020.fullcorountines.data.local.entity.User


class DatabaseHelperImpl(private val appDatabase: AppDatabase) : DatabaseHelper {


    override suspend fun getUsers(): List<User> = appDatabase.userDao().getAll()

    override suspend fun insertAll(users: List<User>) = appDatabase.userDao().insertAll(users)

}