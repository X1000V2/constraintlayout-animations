package com.example.luis.constraintlayoutanimationtest.test2RecyclerviewScreen

import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator
import com.example.luis.constraintlayoutanimationtest.R

class Animation {

    companion object{


        fun animate(show: Boolean, view: MyAdapter.CustomView){

            val constraintLayoutRoot = view.constraintLayoutRoot

            val constraint1 = ConstraintSet()
            if (show) {
//                constraint1.clone(constraintLayoutRoot)
//                val constraint2 = ConstraintSet()
//                constraint2.clone(view.context, R.layout.item_list_expanded)
//
//                val transition = ChangeBounds()
//                transition.interpolator = AnticipateOvershootInterpolator(1.0f)
//                transition.duration = 1200
//
//                TransitionManager.beginDelayedTransition(constraintLayoutRoot, transition)
//                val constraint = constraint2
//                constraint.applyTo(constraintLayoutRoot)

                val constraintSet = ConstraintSet()
                constraintSet.clone(view.context, R.layout.item_list_expanded)

//                val transition = ChangeBounds()
//                transition.interpolator = AnticipateOvershootInterpolator(1.0f)
//                transition.duration = 2000

                TransitionManager.beginDelayedTransition(constraintLayoutRoot)
                constraintSet.applyTo(constraintLayoutRoot)
            } else {
                constraint1.clone(constraintLayoutRoot)
                val constraint2 = ConstraintSet()
                constraint2.clone(view.context, R.layout.item_list)
                TransitionManager.beginDelayedTransition(constraintLayoutRoot)
                val constraint = constraint2
                constraint.applyTo(constraintLayoutRoot)
            }

        }
    }
}