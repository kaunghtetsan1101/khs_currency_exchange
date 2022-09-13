package com.khs.exchange.domain.repo

import com.khs.exchange.domain.model.ExchangeAmount
import com.khs.exchange.domain.model.ExchangeRate
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow

interface ExchangeRepository {
    suspend fun getExchangeRate(source : String, currencies : String) : Flow<DataState<List<ExchangeRate>>>

    suspend fun getExchangeAmount(from : String,to : String,amount : Double) : Flow<DataState<ExchangeAmount>>
}