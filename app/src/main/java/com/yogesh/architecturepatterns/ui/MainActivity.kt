package com.yogesh.architecturepatterns.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.yogesh.architecturepatterns.databinding.ActivityMainBinding
import com.yogesh.architecturepatterns.model.DogResponse
import com.yogesh.architecturepatterns.network.ApiService
import com.yogesh.architecturepatterns.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService: ApiService
    private lateinit var activityMvcBinding: ActivityMainBinding
    private var _dogResponse1: MutableLiveData<DogResponse> = MutableLiveData()
    private var dogResponse1: LiveData<DogResponse> = _dogResponse1
    private var _failure1: MutableLiveData<String> = MutableLiveData()
    private var failure1: LiveData<String> = _failure1

    private var _dogResponse2: MutableStateFlow<Resource<DogResponse>?> = MutableStateFlow(null)
    private var dogResponse2: StateFlow<Resource<DogResponse>?> = _dogResponse2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMvcBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMvcBinding.root)

        attachObservers()
        clickEvents()
    }

    private fun attachObservers() {
        dogResponse1.observe(this) {
            setDogImage(it)
        }

        failure1.observe(this) {
            showToast(it)
        }

        lifecycleScope.launch {
            dogResponse2.collect {
                when (it) {
                    is Resource.Loading -> {

                    }

                    is Resource.Failed -> {
                        showToast(it.message)
                    }

                    is Resource.Success -> {
                        setDogImage(it.data)
                    }


                    else -> {}
                }
            }
        }
    }

    private fun clickEvents() {
        activityMvcBinding.hitBtn.setOnClickListener {
            // with liveData & callbacks
//            callApi1()

            // with stateflow & coroutines
            lifecycleScope.launch {
                callApi2().collect {
                    _dogResponse2.value = it
                }
            }
        }
    }

    private fun callApi2(): Flow<Resource<DogResponse>> = flow {
        emit(Resource.loading())
        emit(Resource.success(apiService.getDog2()))
    }.catch {
        val errorMessage = when (it) {
            is HttpException -> {
                "${it.message()} ${it.code()}"
            }

            else -> {
                "${it.message}"
            }
        }
        emit(Resource.failed(errorMessage))
    }.flowOn(Dispatchers.IO)

    private fun callApi1() {
        apiService.getDog1().enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    _dogResponse1.postValue(response.body())
                } else {
                    _failure1.postValue(response.message() + " " + response.code())
                }
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                _failure1.postValue(t.message.toString())
            }
        })
    }

    private fun setDogImage(body: DogResponse?) {
        Glide.with(this@MainActivity).load(body!!.message).into(activityMvcBinding.img)
    }

    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}