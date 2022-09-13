package com.khs.exchange.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ExchangeRateEntity(
    @PrimaryKey
    @ColumnInfo(name = "SYMBOL")
    val currencySymbol : String,
    @ColumnInfo(name = "RATE")
    val rate : Double
)