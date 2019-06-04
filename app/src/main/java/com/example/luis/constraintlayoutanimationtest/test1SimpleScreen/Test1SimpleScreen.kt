package com.example.luis.constraintlayoutanimationtest.test1SimpleScreen

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import com.example.luis.constraintlayoutanimationtest.R
import kotlinx.android.synthetic.main.test_1_simple_screen.*

class Test1SimpleScreen : AppCompatActivity() {


    var infoIsVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_1_simple_screen)

        button?.setOnClickListener {
            infoIsVisible = !infoIsVisible
            showInfo(infoIsVisible)
        }
    }

    fun showInfo(show: Boolean) {

        val constraintLayoutRoot = findViewById<ConstraintLayout>(R.id.root)

        val constraint1 = ConstraintSet()
        if (show) {
            constraint1.clone(constraintLayoutRoot)
            val constraint2 = ConstraintSet()
            constraint2.clone(this, R.layout.test_1_simple_screen_expanded)
            TransitionManager.beginDelayedTransition(constraintLayoutRoot)
            val constraint = constraint2
            constraint.applyTo(constraintLayoutRoot)
        } else {
            constraint1.clone(constraintLayoutRoot)
            val constraint2 = ConstraintSet()
            constraint2.clone(this, R.layout.test_1_simple_screen)
            TransitionManager.beginDelayedTransition(constraintLayoutRoot)
            val constraint = constraint2
            constraint.applyTo(constraintLayoutRoot)
        }
    }
}