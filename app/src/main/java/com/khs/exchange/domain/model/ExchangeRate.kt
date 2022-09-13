package com.khs.exchange.domain.model

data class ExchangeRate(
    val currencyFromTo : String,
    val rate : Double
)
