package com.yogesh.architecturepatterns.mvc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogesh.architecturepatterns.R
import com.yogesh.architecturepatterns.databinding.ActivityApproachOneBinding
import com.yogesh.architecturepatterns.databinding.ActivityApproachTwoBinding

class Approach_One : AppCompatActivity() {
    private lateinit var activityApproachOneBinding: ActivityApproachOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityApproachOneBinding = ActivityApproachOneBinding.inflate(layoutInflater)
        setContentView(activityApproachOneBinding.root)
    }
}