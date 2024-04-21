package com.yogesh.architecturepatterns.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yogesh.architecturepatterns.R

class MvvmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
    }
}