package com.yogesh.architecturepatterns.presenter

import com.yogesh.architecturepatterns.model.DogResponse
import com.yogesh.architecturepatterns.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class DogPresenter @Inject constructor(private val apiService: ApiService) : DogContract.Presenter {
    lateinit var myView: DogContract.View
    override fun getDog() {
        myView.showLoading()
        getDog1()
    }

    private fun getDog1() {
        apiService.getDog1().enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    myView.showResponse(response.body()!!)
                } else {
                    myView.showError(response.message() + " " + response.code())
                }
                myView.hideLoading()
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                myView.showError(t.message.toString())
                myView.hideLoading()
            }
        })
    }
}