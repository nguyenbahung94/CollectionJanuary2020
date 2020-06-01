package com.example.collectionjanuary2020.fullcorountines.data.local

import com.example.collectionjanuary2020.fullcorountines.data.local.entity.User


interface DatabaseHelper {

    suspend fun getUsers(): List<User>

    suspend fun insertAll(users: List<User>)

}