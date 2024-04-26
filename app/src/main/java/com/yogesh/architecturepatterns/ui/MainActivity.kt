package com.yogesh.architecturepatterns.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.yogesh.architecturepatterns.databinding.ActivityMainBinding
import com.yogesh.architecturepatterns.model.DogResponse
import com.yogesh.architecturepatterns.presenter.DogContract
import com.yogesh.architecturepatterns.presenter.DogPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DogContract.View {
    @Inject
    lateinit var dogPresenter: DogPresenter
    private lateinit var activityMvcBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMvcBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMvcBinding.root)
        initSetup()
        clickEvents()
    }

    private fun initSetup() {
        dogPresenter.myView = this@MainActivity
    }

    private fun clickEvents() {
        activityMvcBinding.hitBtn.setOnClickListener {
            callApi1()
        }
    }

    private fun callApi1() {
        dogPresenter.getDog()
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showResponse(dogResponse: DogResponse) {
        Glide.with(this@MainActivity).load(dogResponse!!.message).into(activityMvcBinding.img)
    }

    override fun showError(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}