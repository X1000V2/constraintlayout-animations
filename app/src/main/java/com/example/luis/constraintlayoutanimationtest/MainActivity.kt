package com.example.luis.constraintlayoutanimationtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import com.example.luis.constraintlayoutanimationtest.test1SimpleScreen.Test1SimpleScreen
import com.example.luis.constraintlayoutanimationtest.test2RecyclerviewScreen.Test2RecyclerViewActivity
import com.example.luis.constraintlayoutanimationtest.test3MotionLayout.Test3MotionLayout
import com.example.luis.constraintlayoutanimationtest.test4ObjectAnimator.Test4ObjectAnimatorActivity
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    var infoIsVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        button_test_1.setOnClickListener {
            startActivity(Intent(this, Test1SimpleScreen::class.java))
        }
        button_test_2.setOnClickListener {
            startActivity(Intent(this, Test2RecyclerViewActivity::class.java))
        }

        button_test_3.setOnClickListener {
            startActivity(Intent(this, Test3MotionLayout::class.java))
        }
        button_test_4.setOnClickListener {
            startActivity(Intent(this, Test4ObjectAnimatorActivity::class.java))
        }

    }
}
