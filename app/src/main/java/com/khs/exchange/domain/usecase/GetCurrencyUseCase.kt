package com.khs.exchange.domain.usecase

import com.khs.exchange.domain.repo.CurrencyRepository
import javax.inject.Inject

class GetCurrencyUseCase @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {
    suspend operator fun invoke() = currencyRepository.getCurrencies()
}