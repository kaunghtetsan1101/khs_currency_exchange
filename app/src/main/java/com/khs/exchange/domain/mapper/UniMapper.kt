package com.khs.exchange.domain.mapper

interface UniMapper<From, To> {

    fun map(item: From): To
}