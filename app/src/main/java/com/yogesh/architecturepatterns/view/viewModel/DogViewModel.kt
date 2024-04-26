package com.yogesh.architecturepatterns.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogesh.architecturepatterns.model.DogResponse
import com.yogesh.architecturepatterns.repository.DogRepository
import com.yogesh.architecturepatterns.utils.ApiListener
import com.yogesh.architecturepatterns.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(val dogRepository: DogRepository) : ViewModel() {

    private var _dogResponseMutableLiveData: MutableLiveData<DogResponse> = MutableLiveData()
    var dogResponseLiveData: LiveData<DogResponse> = _dogResponseMutableLiveData
    private var _failureMutableLiveData: MutableLiveData<String> = MutableLiveData()
    var failureMutableLiveData: LiveData<String> = _failureMutableLiveData

    private var _dogResponseMutableStateFlow: MutableStateFlow<Resource<DogResponse>?> =
        MutableStateFlow(null)
    var dogResponseMutableStateFlow: StateFlow<Resource<DogResponse>?> =
        _dogResponseMutableStateFlow


    private val apiListener: ApiListener = object : ApiListener {

        override fun onSuccess(responseBody: Any, type: String) {
            if (type.equals("dog", true)) {
                _dogResponseMutableLiveData.postValue(responseBody as DogResponse)
            }
        }

        override fun onFailure(message: String) {
            _failureMutableLiveData.postValue(message)
        }

    }

    fun getDog1() {
        dogRepository.getDog1(apiListener)
    }

    fun getDog2() {
        viewModelScope.launch {
            dogRepository.getDog2().collect {
                _dogResponseMutableStateFlow.value = it
            }
        }

    }
}