package com.example.collectionjanuary2020.fullcorountines

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionjanuary2020.R
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.errorhandling.exceptionhandler.ExceptionHandlerActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.errorhandling.supervisor.IgnoreErrorAndContinueActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.errorhandling.trycatch.TryCatchActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.parallel.ParallelNetworkCallsActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.room.RoomDBActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.series.SeriesNetworkCallsActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.single.SingleNetworkCallActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.task.onetask.LongRunningTaskActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.task.twotasks.TwoLongRunningTasksActivity
import com.example.collectionjanuary2020.fullcorountines.learn.retrofit.timeout.TimeoutActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSingleNetworkCallActivity(view: View) {
        startActivity(Intent(this@MainActivity, SingleNetworkCallActivity::class.java))
    }

    fun startSeriesNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, SeriesNetworkCallsActivity::class.java))
    }

    fun startParallelNetworkCallsActivity(view: View) {
        startActivity(Intent(this@MainActivity, ParallelNetworkCallsActivity::class.java))
    }

    fun startRoomDatabaseActivity(view: View) {
        startActivity(Intent(this@MainActivity, RoomDBActivity::class.java))
    }

    fun startTimeoutActivity(view: View) {
        startActivity(Intent(this@MainActivity, TimeoutActivity::class.java))
    }

    fun startTryCatchActivity(view: View) {
        startActivity(Intent(this@MainActivity, TryCatchActivity::class.java))
    }

    fun startExceptionHandlerActivity(view: View) {
        startActivity(Intent(this@MainActivity, ExceptionHandlerActivity::class.java))
    }

    fun startIgnoreErrorAndContinueActivity(view: View) {
        startActivity(Intent(this@MainActivity, IgnoreErrorAndContinueActivity::class.java))
    }

    fun startLongRunningTaskActivity(view: View) {
        startActivity(Intent(this@MainActivity, LongRunningTaskActivity::class.java))
    }

    fun startTwoLongRunningTasksActivity(view: View) {
        startActivity(Intent(this@MainActivity, TwoLongRunningTasksActivity::class.java))
    }

}
