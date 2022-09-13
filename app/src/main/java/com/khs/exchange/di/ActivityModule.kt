package com.khs.exchange.di

import com.khs.exchange.data.api.datasourceImpl.CurrencyNetworkDatasourceImpl
import com.khs.exchange.data.api.datasourceImpl.ExchangeNetworkDatasourceImpl
import com.khs.exchange.data.datasource.currency.CurrencyCacheDatasource
import com.khs.exchange.data.datasource.currency.CurrencyNetworkDatasource
import com.khs.exchange.data.datasource.exchange.ExchangeCacheDatasource
import com.khs.exchange.data.datasource.exchange.ExchangeNetworkDatasource
import com.khs.exchange.data.db.datasourceImpl.CurrencyCacheDatasourceImpl
import com.khs.exchange.data.db.datasourceImpl.ExchangeCacheDatasourceImpl
import com.khs.exchange.data.repoImpl.CurrencyRepoImpl
import com.khs.exchange.data.repoImpl.ExchangeRepoImpl
import com.khs.exchange.domain.repo.CurrencyRepository
import com.khs.exchange.domain.repo.ExchangeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class ActivityModule {

    @Binds
    abstract fun bindCurrencyCacheDatasource(currencyCacheDatasourceImpl: CurrencyCacheDatasourceImpl): CurrencyCacheDatasource

    @Binds
    abstract fun bindCurrencyNetworkDatasource(currencyNetworkDatasourceImpl: CurrencyNetworkDatasourceImpl) : CurrencyNetworkDatasource

    @Binds
    abstract fun bindExchangeCacheDatasource(exchangeCacheDatasourceImpl: ExchangeCacheDatasourceImpl) : ExchangeCacheDatasource

    @Binds
    abstract fun bindExchangeNetworkDatasource(exchangeNetworkDatasourceImpl: ExchangeNetworkDatasourceImpl) : ExchangeNetworkDatasource

    @Binds
    abstract fun bindCurrencyRepository(currencyRepoImpl: CurrencyRepoImpl) : CurrencyRepository

    @Binds
    abstract fun bindExchangeRepository(exchangeRepoImpl: ExchangeRepoImpl) : ExchangeRepository


}