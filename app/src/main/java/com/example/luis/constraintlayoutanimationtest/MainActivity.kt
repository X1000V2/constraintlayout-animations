package com.example.luis.constraintlayoutanimationtest

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.widget.Button
import com.example.luis.constraintlayoutanimationtest.R.id.button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var infoIsVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button?.setOnClickListener {
            infoIsVisible = !infoIsVisible
            showInfo(infoIsVisible)
        }
    }

    private fun showInfo(show: Boolean) {

        val constraintLayoutRoot = findViewById<ConstraintLayout>(R.id.root)
        val constraintLayoutRootExpanded = findViewById<ConstraintLayout>(R.id.root)


        val constraint1 = ConstraintSet()
        if(show){
            constraint1.clone(constraintLayoutRoot)
            val constraint2 = ConstraintSet()
            constraint2.clone(this, R.layout.activity_main_expanded)
            TransitionManager.beginDelayedTransition(constraintLayoutRoot)
            val constraint = constraint2
            constraint.applyTo(constraintLayoutRoot)
        }else{
            constraint1.clone(constraintLayoutRootExpanded)
            val constraint2 = ConstraintSet()
            constraint2.clone(this, R.layout.activity_main)
            TransitionManager.beginDelayedTransition(constraintLayoutRootExpanded)
            val constraint = constraint2
            constraint.applyTo(constraintLayoutRootExpanded)
        }








    }
}
