package com.khs.exchange.domain.usecase

import com.khs.exchange.domain.repo.ExchangeRepository
import javax.inject.Inject

class GetExchangeRateUseCase @Inject constructor(
    private val exchangeRepository: ExchangeRepository
) {
    suspend operator fun invoke(source: String, currencies: String) =
        exchangeRepository.getExchangeRate(
            source = source,
            currencies = currencies,
        )
}