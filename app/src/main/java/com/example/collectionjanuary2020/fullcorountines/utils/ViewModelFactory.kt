package com.example.collectionjanuary2020.fullcorountines.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.collectionjanuary2020.fullcorountines.data.api.ApiHelper
import com.example.collectionjanuary2020.fullcorountines.data.local.DatabaseHelper
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.errorhandling.exceptionhandler.ExceptionHandlerViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.errorhandling.supervisor.IgnoreErrorAndContinueViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.errorhandling.trycatch.TryCatchViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.parallel.ParallelNetworkCallsViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.room.RoomDBViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.series.SeriesNetworkCallsViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.single.SingleNetworkCallViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.task.onetask.LongRunningTaskViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.task.twotasks.TwoLongRunningTasksViewModel
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.timeout.TimeoutViewModel


class ViewModelFactory(private val apiHelper: ApiHelper, private val dbHelper: DatabaseHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SingleNetworkCallViewModel::class.java)) {
            return SingleNetworkCallViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(SeriesNetworkCallsViewModel::class.java)) {
            return SeriesNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ParallelNetworkCallsViewModel::class.java)) {
            return ParallelNetworkCallsViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(RoomDBViewModel::class.java)) {
            return RoomDBViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TimeoutViewModel::class.java)) {
            return TimeoutViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TryCatchViewModel::class.java)) {
            return TryCatchViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(ExceptionHandlerViewModel::class.java)) {
            return ExceptionHandlerViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(LongRunningTaskViewModel::class.java)) {
            return LongRunningTaskViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(TwoLongRunningTasksViewModel::class.java)) {
            return TwoLongRunningTasksViewModel(apiHelper, dbHelper) as T
        }
        if (modelClass.isAssignableFrom(IgnoreErrorAndContinueViewModel::class.java)) {
            return IgnoreErrorAndContinueViewModel(apiHelper, dbHelper) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}