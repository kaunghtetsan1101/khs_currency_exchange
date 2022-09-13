package com.khs.exchange.data.repoImpl

import com.khs.exchange.data.datasource.currency.CurrencyCacheDatasource
import com.khs.exchange.data.datasource.currency.CurrencyNetworkDatasource
import com.khs.exchange.domain.model.Currency
import com.khs.exchange.domain.repo.CurrencyRepository
import com.khs.exchange.utils.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CurrencyRepoImpl @Inject constructor(
    private val currencyCacheDatasource: CurrencyCacheDatasource,
    private val currencyNetworkDatasource: CurrencyNetworkDatasource,
) : CurrencyRepository{
    override suspend fun getCurrencies(): Flow<DataState<List<Currency>>> =
        currencyNetworkDatasource.getCurrencies()
}