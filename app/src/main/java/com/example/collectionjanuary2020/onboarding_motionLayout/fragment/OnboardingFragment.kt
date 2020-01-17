package com.example.collectionjanuary2020.onboarding_motionLayout.fragment

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.transition.Transition
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatDialog
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.DialogFragment
import com.example.collectionjanuary2020.R
import kotlinx.android.synthetic.main.fragment_onboarding.*
import kotlinx.android.synthetic.main.onboading_motion_layout.*

class OnboardingFragment : DialogFragment() {
    private val indicators = mutableListOf<View>()
    private var currentPosition = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AppCompatDialog(context, R.style.DialogFullScreen)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setIndicators()
        updateIndicators()
        attachNextButtonListener()
        attachPreviousButtonListener()
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
                //do something
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
                //do something
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                //do something
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                //do something
                Log.e("current id = ", p1.toString())
            }

        })

    }

    private fun attachPreviousButtonListener() {
        previous.setOnClickListener {
            when (currentPosition) {
                2 -> previous.navigate(R.id.thirdTransition, R.id.secondTransition)
                else -> previous.navigate(R.id.secondTransition, R.id.firstTransition)
            }
        }
    }

    private fun attachNextButtonListener() {
        next.setOnClickListener {
            when (currentPosition) {
                0 -> next.navigate(R.id.firstTransition, R.id.secondTransition)
                1 -> next.navigate(R.id.secondTransition, R.id.thirdTransition)
                else -> dismiss()
            }
        }
    }

    private fun Button.navigate(startId: Int, endId: Int) {
        currentPosition = when (id) {
            R.id.next -> currentPosition.inc()
            else -> currentPosition.dec()
        }
        updateNavState()
        if (endId == R.id.thirdTransition) {
            navContainer.setBackgroundColor(resources.getColor(R.color.color_onboarding_page3))
            next.setText(R.string.button_text_complete)
        } else {
            next.setText(R.string.button_text_next)
            navContainer.setBackgroundColor(resources.getColor(R.color.onboarding_background))
        }

        motionLayout.setTransition(startId, endId)
        motionLayout.setTransitionDuration(600)
        // motionLayout.setTransition(R.id.firstTransition, R.id.secondTransition)
        motionLayout.transitionToEnd()
        motionLayout.requestLayout()
        updateIndicators()
    }

    private fun updateNavState() {
        when {
            currentPosition > 0 -> previous.visibility = View.VISIBLE
            else -> previous.visibility = View.INVISIBLE
        }
    }

    private fun updateIndicators() {
        indicators.forEachIndexed { index, view ->
            val background = when (index) {
                currentPosition -> R.drawable.selected_dot
                else -> R.drawable.un_selected_dot
            }
            view.setBackgroundDrawable(context?.getDrawable(background))
        }
    }


    private fun setIndicators() {
        val dotRadius: Int = convertDpToPixel(12f, context)
        val margin: Int = convertDpToPixel(4f, context)
        indicators.clear()
        indicatorsContainer.removeAllViews()
        for (i in 0 until 3) {
            val view = View(context)
            view.id = View.generateViewId()
            val layoutParams = FrameLayout.LayoutParams(dotRadius * 2, dotRadius * 2)
            layoutParams.setMargins(margin, margin, margin, margin)
            view.layoutParams = layoutParams
            indicators.add(view)
            indicatorsContainer.addView(view)
        }
    }

    private fun convertDpToPixel(dp: Float, context: Context?): Int {
        if (context != null) {
            return (dp * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
        }
        return 0
    }
}