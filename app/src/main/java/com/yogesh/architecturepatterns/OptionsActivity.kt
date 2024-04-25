package com.yogesh.architecturepatterns

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogesh.architecturepatterns.databinding.ActivityOptionsBinding
import com.yogesh.architecturepatterns.mvc.MvcActivity
import com.yogesh.architecturepatterns.mvp.ui.MvpActivity
import com.yogesh.architecturepatterns.mvvm.ui.MvvmActivity

class OptionsActivity : AppCompatActivity() {
    private lateinit var activityOptionsBinding: ActivityOptionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityOptionsBinding = ActivityOptionsBinding.inflate(layoutInflater)
        setContentView(activityOptionsBinding.root)

        clickEvents()
    }

    private fun clickEvents() {

        activityOptionsBinding.mvcBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MvcActivity::class.java
                )
            )
        }

        activityOptionsBinding.mvpBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MvpActivity::class.java
                )
            )
        }

        activityOptionsBinding.mvvmBtn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    MvvmActivity::class.java
                )
            )
        }
    }
}