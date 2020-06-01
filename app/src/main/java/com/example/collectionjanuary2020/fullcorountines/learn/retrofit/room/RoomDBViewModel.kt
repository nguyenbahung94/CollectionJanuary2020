package com.example.collectionjanuary2020.fullcorountines.learn.retrofit.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collectionjanuary2020.fullcorountines.data.api.ApiHelper
import com.example.collectionjanuary2020.fullcorountines.data.local.DatabaseHelper
import com.example.collectionjanuary2020.fullcorountines.data.local.entity.User
import com.example.collectionjanuary2020.fullcorountines.utils.Resource
import kotlinx.coroutines.launch

class RoomDBViewModel(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModel() {

    private val users = MutableLiveData<Resource<List<User>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromDb = dbHelper.getUsers()
                if (usersFromDb.isEmpty()) {
                    val usersFromApi = apiHelper.getUsers()
                    val usersToInsertInDB = mutableListOf<User>()

                    for (apiUser in usersFromApi) {
                        val user = User(
                            apiUser.id,
                            apiUser.name,
                            apiUser.email,
                            apiUser.avatar
                        )
                        usersToInsertInDB.add(user)
                    }

                    dbHelper.insertAll(usersToInsertInDB)

                    users.postValue(Resource.success(usersToInsertInDB))

                } else {
                    users.postValue(Resource.success(usersFromDb))
                }


            } catch (e: Exception) {
                users.postValue(Resource.error("Something Went Wrong", null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<User>>> {
        return users
    }

}