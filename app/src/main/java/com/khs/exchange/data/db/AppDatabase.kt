package com.khs.exchange.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.khs.exchange.data.db.entities.ExchangeRateEntity

@Database(
    entities = [ExchangeRateEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
}