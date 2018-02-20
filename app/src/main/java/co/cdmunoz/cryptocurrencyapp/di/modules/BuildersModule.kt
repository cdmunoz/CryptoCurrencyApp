package co.cdmunoz.cryptocurrencyapp.di.modules

import co.cdmunoz.cryptocurrencyapp.CryptocurrenciesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

  @ContributesAndroidInjector
  abstract fun contributeCryptocurrenciesActivity(): CryptocurrenciesActivity
}