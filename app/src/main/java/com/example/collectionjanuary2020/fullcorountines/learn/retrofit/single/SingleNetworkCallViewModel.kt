package com.example.collectionjanuary2020.fullcorountines.learn.retrofit.single

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collectionjanuary2020.fullcorountines.data.api.ApiHelper
import com.example.collectionjanuary2020.fullcorountines.data.local.DatabaseHelper
import com.example.collectionjanuary2020.fullcorountines.data.model.ApiUser
import com.example.collectionjanuary2020.fullcorountines.utils.Resource
import kotlinx.coroutines.launch

class SingleNetworkCallViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val users = MutableLiveData<Resource<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            users.postValue(Resource.loading(null))
            try {
                val usersFromApi = apiHelper.getUsers()
                users.postValue(Resource.success(usersFromApi))
            } catch (e: Exception) {
                users.postValue(Resource.error(e.toString(), null))
            }
        }
    }

    fun getUsers(): LiveData<Resource<List<ApiUser>>> {
        return users
    }

}