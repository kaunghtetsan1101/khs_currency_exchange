package com.khs.exchange.data.api.mapper

import com.khs.exchange.domain.mapper.UniMapper
import com.khs.exchange.domain.model.ExchangeRate
import javax.inject.Inject

class ExchangeRateJsonMapper @Inject constructor() : UniMapper<Map<String,Double>,List<ExchangeRate>>{
    override fun map(item: Map<String, Double>): List<ExchangeRate> =
        item.map {
            ExchangeRate(
                currencyFromTo = it.key ,
                rate = it.value
            )
        }
}