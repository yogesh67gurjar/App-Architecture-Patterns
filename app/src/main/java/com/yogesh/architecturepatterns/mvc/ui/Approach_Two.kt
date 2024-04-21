package com.yogesh.architecturepatterns.mvc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogesh.architecturepatterns.R
import com.yogesh.architecturepatterns.databinding.ActivityApproachTwoBinding

class Approach_Two : AppCompatActivity() {
    lateinit var activityApproachTwoBinding: ActivityApproachTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityApproachTwoBinding = ActivityApproachTwoBinding.inflate(layoutInflater)
        setContentView(activityApproachTwoBinding.root)
    }
}