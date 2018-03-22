package co.cdmunoz.cryptocurrencyapp.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import co.cdmunoz.cryptocurrencyapp.model.Cryptocurrency

@Dao
interface CryptocurrenciesDao {

  @Query("SELECT * FROM cryptocurrency")
  fun queryCryptocurrencies(): LiveData<List<Cryptocurrency>>

  @Insert(
      onConflict = OnConflictStrategy.REPLACE
  )
  fun insertCryptocurrency(cryptocurrency: Cryptocurrency)
}