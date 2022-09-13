package com.khs.exchange.data.api.datasourceImpl

import com.khs.exchange.data.api.ApiService
import com.khs.exchange.data.api.mapper.CurrencyJsonMapper
import com.khs.exchange.data.datasource.currency.CurrencyNetworkDatasource
import com.khs.exchange.domain.model.Currency
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurrencyNetworkDatasourceImpl @Inject constructor(
    private val apiService: ApiService,
    private val currencyMapper: CurrencyJsonMapper
) : CurrencyNetworkDatasource {
    override suspend fun getCurrencies(): Flow<DataState<List<Currency>>> = flow {
        emit(DataState.Loading)
        val response = apiService.getCurrencies()
        if (response.success){
            emit(DataState.Success(currencyMapper.map(response.currencies)))
        } else {
            emit(DataState.Error(
                "not success"
            ))
        }
    }
}