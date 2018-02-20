package co.cdmunoz.cryptocurrencyapp.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import co.cdmunoz.cryptocurrencyapp.model.Cryptocurrency

@Database(entities = arrayOf(Cryptocurrency::class), version = 1)
abstract class Database : RoomDatabase() {
  abstract fun cryptocurrenciesDao(): CryptocurrenciesDao
}