package com.khs.exchange.data.api.mapper

import com.khs.exchange.data.api.response.ExchangeAmountResponse
import com.khs.exchange.domain.mapper.UniMapper
import com.khs.exchange.domain.model.ExchangeAmount
import javax.inject.Inject

class ExchangeAmountJsonMapper  @Inject constructor() : UniMapper<ExchangeAmountResponse,ExchangeAmount>{
    override fun map(item: ExchangeAmountResponse): ExchangeAmount =
        with(item){
            ExchangeAmount(
                from = query.from,
                to = query.to,
                quote = info.quote,
                amount = query.amount ,
                resultAmount = result
            )
        }

}