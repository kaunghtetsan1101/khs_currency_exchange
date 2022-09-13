package com.khs.exchange.data.api.mapper

import com.khs.exchange.domain.mapper.UniMapper
import com.khs.exchange.domain.model.Currency
import javax.inject.Inject

class CurrencyJsonMapper @Inject constructor() : UniMapper<Map<String,String>,List<Currency>> {
    override fun map(item: Map<String, String>): List<Currency> =
        item.map {
            Currency(
                it.key,
                it.value
            )
        }
}