package com.yogesh.architecturepatterns.view.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogesh.architecturepatterns.data.model.DogResponse
import com.yogesh.architecturepatterns.domain.repository.DogRepository
import com.yogesh.architecturepatterns.domain.useCases.DogUseCases
import com.yogesh.architecturepatterns.utils.ApiListener
import com.yogesh.architecturepatterns.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(private val dogUseCases: DogUseCases) : ViewModel() {
    private var _dogResponseMutableStateFlow: MutableStateFlow<Resource<DogResponse>?> =
        MutableStateFlow(null)
    var dogResponseMutableStateFlow: StateFlow<Resource<DogResponse>?> =
        _dogResponseMutableStateFlow


    fun getDog() {
        viewModelScope.launch {
            dogUseCases.getDog().collect {
                _dogResponseMutableStateFlow.value = it
            }
        }

    }
}