package com.khs.exchange.data.api.datasourceImpl

import com.khs.exchange.data.api.ApiService
import com.khs.exchange.data.api.mapper.ExchangeAmountJsonMapper
import com.khs.exchange.data.api.mapper.ExchangeRateJsonMapper
import com.khs.exchange.data.datasource.exchange.ExchangeNetworkDatasource
import com.khs.exchange.domain.model.ExchangeAmount
import com.khs.exchange.domain.model.ExchangeRate
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExchangeNetworkDatasourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val rateMapper : ExchangeRateJsonMapper,
    private val amountMapper : ExchangeAmountJsonMapper,
) : ExchangeNetworkDatasource {
    override suspend fun getExchangeRate(
        source: String,
        currencies: String
    ): Flow<DataState<List<ExchangeRate>>> = flow {
        emit(DataState.Loading)
        val response = apiService.getExchangeRate(source,currencies)
        if (response.success){
            emit(DataState.Success(rateMapper.map(response.quotes)))
        } else {
            emit(DataState.Error(
                "not success"
            ))
        }
    }

    override suspend fun getExchangeAmount(
        from: String,
        to: String,
        amount: Double
    ): Flow<DataState<ExchangeAmount>> = flow {
        emit(DataState.Loading)
        val response = apiService.getExchangeAmount(from, to, amount)
        if (response.success){
            emit(DataState.Success(amountMapper.map(response)))
        } else {
            emit(DataState.Error(
                "not success"
            ))
        }
    }
}