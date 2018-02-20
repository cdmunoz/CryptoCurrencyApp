package co.cdmunoz.cryptocurrencyapp.di.component

import android.app.Application
import co.cdmunoz.cryptocurrencyapp.di.modules.AppModule
import co.cdmunoz.cryptocurrencyapp.di.modules.BuildersModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class)
)
interface AppComponent {
  fun inject(app: Application)
}