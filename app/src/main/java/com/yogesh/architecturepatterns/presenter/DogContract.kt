package com.yogesh.architecturepatterns.presenter

import com.yogesh.architecturepatterns.model.DogResponse

interface DogContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showResponse(dogResponse: DogResponse)
        fun showError(message: String)
    }

    interface Presenter {
        fun getDog()
    }
}