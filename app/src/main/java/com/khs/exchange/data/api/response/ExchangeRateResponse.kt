package com.khs.exchange.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExchangeRateResponse(
    val success: Boolean,
    val timestamp: Int,
    val source: String,
    val quotes: Map<String,Double>
)