package com.yogesh.architecturepatterns.mvc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogesh.architecturepatterns.R
import com.yogesh.architecturepatterns.databinding.ActivityMvcBinding
import com.yogesh.architecturepatterns.mvp.ui.MvpActivity

class MvcActivity : AppCompatActivity() {
    private lateinit var activityMvcBinding: ActivityMvcBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMvcBinding = ActivityMvcBinding.inflate(layoutInflater)
        setContentView(activityMvcBinding.root)

        clickEvents()
    }

    private fun clickEvents() {
        activityMvcBinding.approachOneBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    Approach_One::class.java
                )
            )
        }

        activityMvcBinding.approachTwoBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    Approach_Two::class.java
                )
            )
        }
    }
}