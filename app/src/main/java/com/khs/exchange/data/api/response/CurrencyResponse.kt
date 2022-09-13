package com.khs.exchange.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyResponse(
    val success: Boolean,
    val currencies: Map<String,String>
)
