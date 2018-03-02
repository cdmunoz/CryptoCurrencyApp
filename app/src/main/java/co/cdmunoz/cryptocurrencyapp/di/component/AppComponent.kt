package co.cdmunoz.cryptocurrencyapp.di.component

import co.cdmunoz.cryptocurrencyapp.CryptocurrencyApplication
import co.cdmunoz.cryptocurrencyapp.di.modules.AppModule
import co.cdmunoz.cryptocurrencyapp.di.modules.BuildersModule
import co.cdmunoz.cryptocurrencyapp.di.modules.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class,
        NetModule::class)
)
interface AppComponent {
  fun inject(app: CryptocurrencyApplication)
}