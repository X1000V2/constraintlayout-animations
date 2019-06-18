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

    var customSwipeLayout: CustomSwipeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4_object_animator)

        var viewOut = findViewById<ConstraintLayout>(R.id.constraintLayoutToFlip)

        var viewIn = findViewById<ConstraintLayout>(R.id.constraintLayoutToFlipBack)

        customSwipeLayout = CustomSwipeLayout(this, viewOut, viewIn, 300L)
        button_move.setOnClickListener {
            customSwipeLayout?.flip()
        }

    }


}
