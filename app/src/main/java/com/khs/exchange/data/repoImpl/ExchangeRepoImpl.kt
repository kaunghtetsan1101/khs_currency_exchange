package com.khs.exchange.data.repoImpl

import com.khs.exchange.data.datasource.exchange.ExchangeCacheDatasource
import com.khs.exchange.data.datasource.exchange.ExchangeNetworkDatasource
import com.khs.exchange.domain.model.ExchangeAmount
import com.khs.exchange.domain.model.ExchangeRate
import com.khs.exchange.domain.repo.ExchangeRepository
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExchangeRepoImpl @Inject constructor(
    private val exchangeCacheDatasource: ExchangeCacheDatasource,
    private val exchangeNetworkDatasource: ExchangeNetworkDatasource
) : ExchangeRepository {
    override suspend fun getExchangeRate(
        source: String,
        currencies: String
    ): Flow<DataState<List<ExchangeRate>>> = exchangeNetworkDatasource.getExchangeRate(
        source = source,
        currencies = currencies
    )

    override suspend fun getExchangeAmount(
        from: String,
        to: String,
        amount: Double
    ): Flow<DataState<ExchangeAmount>> = exchangeNetworkDatasource.getExchangeAmount(
        from = from,
        to = to,
        amount = amount
    )
}