package com.example.collectionjanuary2020.splash.new

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionjanuary2020.R
import com.example.collectionjanuary2020.advance_kotlin.customview.AdvanceMainActivity
import kotlinx.coroutines.*

class CoroutinesSplashActivity : AppCompatActivity() {

    val activityScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corountines_splash)
        activityScope.launch {
            delay(300)

            var intent = Intent(this@CoroutinesSplashActivity, AdvanceMainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onPause() {
        activityScope.cancel()
        super.onPause()
    }

}