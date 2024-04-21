package com.yogesh.architecturepatterns.mvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogesh.architecturepatterns.R

class MvpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
    }
}