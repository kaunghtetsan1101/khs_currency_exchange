package com.khs.exchange.data.api

import com.khs.exchange.data.api.response.CurrencyResponse
import com.khs.exchange.data.api.response.ExchangeAmountResponse
import com.khs.exchange.data.api.response.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("list")
    suspend fun getCurrencies(): CurrencyResponse

    @GET("live")
    suspend fun getExchangeRate(
        @Query("source") source: String,
        @Query("currencies") currencies: String,
    ): ExchangeRateResponse

    @GET("convert")
    suspend fun getExchangeAmount(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: Double
    ): ExchangeAmountResponse
}