package com.khs.exchange.domain.model

data class ExchangeAmount(
    val from : String,
    val to : String,
    val amount : Double,
    val quote : Double,
    val resultAmount  : Double
)
