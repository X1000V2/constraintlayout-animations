package com.example.luis.constraintlayoutanimationtest.test4ObjectAnimator

import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import com.example.luis.constraintlayoutanimationtest.R
import java.util.*

class CustomSwipeLayout(val context: Context, val viewFront: View, val viewBack: View, val animationDuration: Long) {


    init{

        //viewFront.cameraDistance =10F * viewFront.width
        //viewBack.cameraDistance = 10F * viewBack.width

        //Camera distance perspective
        viewFront.cameraDistance =viewFront.cameraDistance * 7F
        viewBack.cameraDistance = viewBack.cameraDistance * 7F

        val timerr = Timer()
        val LONG_PRESS_TIMEOUT: Long = 500 // TODO: your timeout here
        val wasLong = false

        var x1: Float = 0F
        var x2: Float = 0F
        var y1: Float = 0F
        var y2: Float = 0F
        var t1: Long = Date().time
        var t2: Long = Date().time

        viewFront.setOnTouchListener { view, motionEvent ->

            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> {
                    x1 = motionEvent.getX();
                    y1 = motionEvent.getY();
                    t1 = Date().time;
                }
                MotionEvent.ACTION_UP -> {
                    x2 = motionEvent.getX();
                    y2 = motionEvent.getY();
                    t2 = Date().time

                    if (x1 == x2 && y1 == y2 && (t2 - t1) < 200) {
                        //Click
                        println("Click")
                    } else if ((t2 - t1) >= LONG_PRESS_TIMEOUT) {
                        //Long click
                        println("Long click")
                    } else if (x1 > x2) {
                        //Left swipe
                        println("Left swipe")
                    } else if (x2 > x1) {
                        //Right swipe
                        println("Right swipe")
                        flip()
                    }
                }
            }

            true
        }

        viewBack.setOnTouchListener { view, motionEvent ->

            when(motionEvent.action){
                MotionEvent.ACTION_DOWN -> {
                    x1 = motionEvent.getX();
                    y1 = motionEvent.getY();
                    t1 = Date().time;
                }
                MotionEvent.ACTION_UP -> {
                    x2 = motionEvent.getX();
                    y2 = motionEvent.getY();
                    t2 = Date().time

                    if (x1 == x2 && y1 == y2 && (t2 - t1) < 100) {
                        //Click
                        println("Click")
                    } else if ((t2 - t1) >= LONG_PRESS_TIMEOUT) {
                        //Long click
                        println("Long click")
                    } else if (x1 > x2) {
                        //Left swipe
                        println("Left swipe")
                        flipReverse()
                    } else if (x2 > x1) {
                        //Right swipe
                        println("Right swipe")
                    }
                }
            }

            true
        }
    }

    fun flip() {

        val anim = AnimatorInflater.loadAnimator(
                context, R.animator.object_animator) as ObjectAnimator
        anim.target = viewFront
        anim.duration = animationDuration
        anim.end()
        anim.start()

        val anim2 = AnimatorInflater.loadAnimator(
                context, R.animator.object_animator_back) as ObjectAnimator
        anim2.target = viewBack
        anim2.duration = animationDuration
        anim2.end()
        anim2.start()

        Handler().postDelayed({
            viewFront.visibility = View.GONE
            viewBack.visibility = View.VISIBLE
        },animationDuration/2)
    }

    fun flipReverse() {

        val anim = AnimatorInflater.loadAnimator(
                context, R.animator.object_animator_reverse) as ObjectAnimator
        anim.target = viewFront
        anim.duration = animationDuration
        anim.end()
        anim.start()

        val anim2 = AnimatorInflater.loadAnimator(
                context, R.animator.object_animator_back_reverse) as ObjectAnimator
        anim2.target = viewBack
        anim2.duration = animationDuration
        anim2.end()
        anim2.start()

        Handler().postDelayed({
            viewFront.visibility = View.VISIBLE
            viewBack.visibility = View.GONE
        },animationDuration/2)
    }
}