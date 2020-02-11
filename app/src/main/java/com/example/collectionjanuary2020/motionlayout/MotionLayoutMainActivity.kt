package com.example.collectionjanuary2020.motionlayout

import android.os.Bundle
import androidx.annotation.StringDef
import androidx.appcompat.app.AppCompatActivity
import com.example.collectionjanuary2020.R
import kotlinx.android.synthetic.main.motionlayout_main_activity.*

class MotionLayoutMainActivity : AppCompatActivity() {
    private val searchFragment by lazy { supportFragmentManager.findFragmentById(R.id.searchFragment) as SearchFragment }
    private val settingsFragment by lazy { supportFragmentManager.findFragmentById(R.id.settingsFragment) as SettingsFragment }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motionlayout_main_activity)
    }

    fun searchFragmentMotion(motionWrapper: MotionWrapper) {
        setSearchTransition()
        when (motionWrapper.motionState) {
            MotionWrapper.MOTION_STARTED -> {
            }
            MotionWrapper.MOTION_COMPLETED -> {
                screenState = if (motionWrapper.isStart) {
                    motionLayout.progress = 0f
                    MAIN
                } else {
                    motionLayout.progress = 100f
                    SEARCH
                }
            }
            MotionWrapper.MOTION_PROGRESS -> {
                motionLayout.progress = motionWrapper.progress
            }
        }
    }

    fun settingsFragmentMotion(motionWrapper: MotionWrapper) {
        setSettingsTransition()
        when (motionWrapper.motionState) {
            MotionWrapper.MOTION_STARTED -> {
            }
            MotionWrapper.MOTION_COMPLETED -> {
                screenState = if (motionWrapper.isStart) {
                    motionLayout.progress = 0f
                    MAIN
                } else {
                    motionLayout.progress = 100f
                    SETTING
                }
            }
            MotionWrapper.MOTION_PROGRESS -> {
                motionLayout.progress = motionWrapper.progress
            }
        }
    }

    private fun setSearchTransition() {
        motionLayout.setTransition(R.id.startSearch, R.id.endSearch)
    }

    private fun setSettingsTransition() {
        motionLayout.setTransition(R.id.startSetting, R.id.endSetting)
    }

    private fun transitionFromSearchPage() {
        searchFragment.revertMotion()
    }

    private fun transitionFromSettingsPage() {
        settingsFragment.revertMotion()
    }

    override fun onBackPressed() {
        when (screenState) {
            MAIN -> super.onBackPressed()
            SEARCH -> {
                transitionFromSearchPage()
            }
            SETTING -> {
                transitionFromSettingsPage()
            }
        }
    }

    @ScreenState
    private var screenState: String = MAIN

    companion object {
        @StringDef(MAIN, SETTING, SEARCH)
        annotation class ScreenState

        const val MAIN = "main"
        const val SETTING = "setting"
        const val SEARCH = "search"
    }
}