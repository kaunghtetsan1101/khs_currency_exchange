package com.khs.exchange.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExchangeAmountResponse(
    val success: Boolean,
    val query : ExchangeQuery,
    val info : ExchangeInfo,
    val result : Double
)

data class ExchangeQuery(
    val from : String,
    val to : String,
    val amount : Double
)

data class ExchangeInfo(
    val quote : Double
)