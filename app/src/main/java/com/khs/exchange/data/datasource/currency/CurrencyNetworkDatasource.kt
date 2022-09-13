package com.khs.exchange.data.datasource.currency

import com.khs.exchange.domain.model.Currency
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow

interface CurrencyNetworkDatasource {
    suspend fun getCurrencies() : Flow<DataState<List<Currency>>>
}