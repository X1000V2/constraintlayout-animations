package com.example.luis.constraintlayoutanimationtest.test4ObjectAnimator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.animation.AnimatorInflater
import android.animation.ObjectAnimator
import android.content.Context
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.view.MotionEvent
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_test4_object_animator.*
import android.widget.Toast
import com.example.luis.constraintlayoutanimationtest.R
import java.sql.Time
import java.util.*


class Test4ObjectAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4_object_animator)

        var viewOut = findViewById<ConstraintLayout>(R.id.constraintLayoutToFlip)

        var viewIn = findViewById<ConstraintLayout>(R.id.constraintLayoutToFlipBack)
        button_move.setOnClickListener {
            flip(this,viewOut,viewIn)
        }

        val timerr = Timer()
        val LONG_PRESS_TIMEOUT: Long = 400 // TODO: your timeout here
        val wasLong = false

        var x1: Float = 0F
        var x2: Float = 0F
        var y1: Float = 0F
        var y2: Float = 0F
        var t1: Long = Date().time
        var t2: Long = Date().time

        viewOut.setOnTouchListener { view, motionEvent ->

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
                    } else if ((t2 - t1) >= 500) {
                        //Long click
                        println("Long click")
                    } else if (x1 > x2) {
                        //Left swipe
                        println("Left swipe")
                    } else if (x2 > x1) {
                        //Right swipe
                        println("Right swipe")
                        flip(this,viewOut,viewIn)
                    }
                }
            }

           true
        }

    }

    fun flip(context: Context, viewOut: View, viewIn: View) {

        viewOut.visibility = VISIBLE

        val anim = AnimatorInflater.loadAnimator(
                context, R.animator.object_animator) as ObjectAnimator
        anim.target = viewOut
        anim.duration = 1000
        anim.end()
        anim.start()



        val anim2 = AnimatorInflater.loadAnimator(
                context, R.animator.object_animator_back) as ObjectAnimator
        anim2.target = viewIn
        anim2.duration = 1000
        anim2.end()
        anim2.start()

        Handler().postDelayed({
            viewOut.visibility = GONE
            viewIn.visibility = VISIBLE
        },500)

    }
}
