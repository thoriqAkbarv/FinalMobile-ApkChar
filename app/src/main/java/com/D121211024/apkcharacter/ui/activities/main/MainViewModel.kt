package com.D121211024.apkcharacter.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211024.apkcharacter.MyApplication
import com.D121211024.apkcharacter.data.model.Data
import com.D121211024.apkcharacter.data.repository.FactsRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val facts: List<Data>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val factsRepository: FactsRepository): ViewModel() {

    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getFacts() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = factsRepository.getFacts()
            mainUiState = MainUiState.Success(result.data.orEmpty())
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    init {
        getFacts()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val factsRepository = application.container.factsRepository
                MainViewModel(factsRepository)
            }
        }
    }
}