package co.cdmunoz.cryptocurrencyapp.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import co.cdmunoz.cryptocurrencyapp.data.Cryptocurrency

@Database(entities = arrayOf(Cryptocurrency::class), version = 8)
abstract class Database : RoomDatabase() {
  abstract fun cryptocurrenciesDao(): CryptocurrenciesDao
}