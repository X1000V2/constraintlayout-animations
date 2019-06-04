package com.example.luis.constraintlayoutanimationtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import com.example.luis.constraintlayoutanimationtest.test1SimpleScreen.Test1SimpleScreen
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    var infoIsVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        button_test_1.setOnClickListener {
            startActivity(Intent(this, Test1SimpleScreen::class.java))
        }

    }
}
