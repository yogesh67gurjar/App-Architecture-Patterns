package com.yogesh.architecturepatterns.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.yogesh.architecturepatterns.databinding.ActivityMainBinding
import com.yogesh.architecturepatterns.utils.Resource
import com.yogesh.architecturepatterns.view.viewModel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val dogViewModel: DogViewModel by viewModels()

    private lateinit var activityMvcBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMvcBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMvcBinding.root)

        attachObservers()
        clickEvents()
    }

    private fun attachObservers() {
        dogViewModel.dogResponseLiveData.observe(this) {
            Glide.with(this@MainActivity).load(it.message).into(activityMvcBinding.img)
        }

        dogViewModel.failureMutableLiveData.observe(this) {
            Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
        }

        lifecycleScope.launch {
            dogViewModel.dogResponseMutableStateFlow.collect {
                when (it) {
                    is Resource.Loading -> {

                    }

                    is Resource.Success -> {
                        Glide.with(this@MainActivity).load(it.data.message)
                            .into(activityMvcBinding.img)
                    }

                    is Resource.Failed -> {
                        Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                    }

                    else -> {}
                }
            }
        }
    }


    private fun clickEvents() {
        activityMvcBinding.hitBtn.setOnClickListener {
            // liveData
//            callApi1()

            // stateflow
            callApi2()
        }
    }

    private fun callApi2() {
        dogViewModel.getDog2()
    }

    private fun callApi1() {
        dogViewModel.getDog1()
    }
}