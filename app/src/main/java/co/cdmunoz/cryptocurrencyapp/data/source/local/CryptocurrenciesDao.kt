package co.cdmunoz.cryptocurrencyapp.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import co.cdmunoz.cryptocurrencyapp.data.Cryptocurrency
import io.reactivex.Single

@Dao
interface CryptocurrenciesDao {

  @Query("SELECT * FROM cryptocurrencies")
  fun queryCryptocurrencies(): Single<List<Cryptocurrency>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertCryptocurrency(cryptocurrency: Cryptocurrency)

  @Insert(
      onConflict = OnConflictStrategy.REPLACE
  )
  fun insertAllCryptocurrencies(cryptocurrencies: List<Cryptocurrency>)
}