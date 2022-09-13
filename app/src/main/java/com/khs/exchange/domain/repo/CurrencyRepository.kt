package com.khs.exchange.domain.repo

import com.khs.exchange.domain.model.Currency
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow

interface CurrencyRepository {

    suspend fun getCurrencies() : Flow<DataState<List<Currency>>>

}