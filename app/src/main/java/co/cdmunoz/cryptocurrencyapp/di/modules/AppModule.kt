package co.cdmunoz.cryptocurrencyapp.di.modules

import android.app.Application
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.migration.Migration
import co.cdmunoz.cryptocurrencyapp.data.source.local.CryptocurrenciesDao
import co.cdmunoz.cryptocurrencyapp.data.source.local.Database
import co.cdmunoz.cryptocurrencyapp.ui.list.CryptocurrenciesViewModelFactory
import co.cdmunoz.cryptocurrencyapp.utils.Constants
import co.cdmunoz.cryptocurrencyapp.utils.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(val app: Application) {

  companion object {
    val MIGRATION_1_2: Migration = object : Migration(1, 2){
      override fun migrate(database: SupportSQLiteDatabase) {
        // Change the table name to the correct one
        database.execSQL("ALTER TABLE cryptocurrency RENAME TO cryptocurrencies")
      }
    }
  }

  @Provides
  @Singleton
  fun provideApplication(): Application = app

  @Provides
  @Singleton
  fun provideCryptocurrenciesDatabase(app: Application): Database = Room.databaseBuilder(app,
      Database::class.java, Constants.DATABASE_NAME)
      /*.addMigrations(MIGRATION_1_2)*/
      .fallbackToDestructiveMigration()
      .build()

  @Provides
  @Singleton
  fun provideCryptocurrenciesDao(
      database: Database): CryptocurrenciesDao = database.cryptocurrenciesDao()

  @Provides
  @Singleton
  fun provideCryptocurrenciesViewModelFactory(
      factory: CryptocurrenciesViewModelFactory): ViewModelProvider.Factory = factory

  @Provides
  @Singleton
  fun provideUtils(): Utils = Utils(app)
}