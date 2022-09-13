package com.khs.exchange.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khs.exchange.domain.usecase.GetCurrencyUseCase
import com.khs.exchange.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val getCurrencyUseCase: GetCurrencyUseCase
) : ViewModel() {

    fun init() {
        viewModelScope.launch {
            getCurrencyUseCase()
                .flowOn(Dispatchers.IO)
                .catch { cause: Throwable ->
                    print(cause.message)
                }
                .onCompletion { }
                .collect {
                    when (it) {
                        is DataState.Loading -> {}
                        is DataState.Success -> {
                            println(it.result.size)
                        }
                        is DataState.Error -> {

                        }
                    }
                }

        }
    }
}