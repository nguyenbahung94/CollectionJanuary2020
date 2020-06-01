package com.example.collectionjanuary2020.fullcorountines.data.api

import com.example.collectionjanuary2020.fullcorountines.data.model.ApiUser


interface ApiHelper {

    suspend fun getUsers(): List<ApiUser>

    suspend fun getMoreUsers(): List<ApiUser>

    suspend fun getUsersWithError(): List<ApiUser>

}