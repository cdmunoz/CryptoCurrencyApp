package co.cdmunoz.cryptocurrencyapp.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import co.cdmunoz.cryptocurrencyapp.dao.CryptocurrenciesDao
import co.cdmunoz.cryptocurrencyapp.dao.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val app: Application) {

  @Provides
  @Singleton
  fun provideApplication(): Application = app

  @Provides
  @Singleton
  fun provideCryptocurrenciesDatabase(app: Application): Database = Room.databaseBuilder(app,
      Database::class.java, "cryptocurrencies_db").build()

  @Provides
  @Singleton
  fun provideCryptocurrenciesDao(database: Database): CryptocurrenciesDao = database.cryptocurrenciesDao()
}