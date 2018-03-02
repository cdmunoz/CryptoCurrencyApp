package co.cdmunoz.cryptocurrencyapp.ui.list

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.cdmunoz.cryptocurrencyapp.R.layout
import co.cdmunoz.cryptocurrencyapp.data.Cryptocurrency
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.hello_world_textview
import javax.inject.Inject

class CryptocurrenciesActivity : AppCompatActivity() {

  @Inject
  lateinit var cryptocurrenciesViewModelFactory: CryptocurrenciesViewModelFactory
  lateinit var cryptocurrenciesViewModel: CryptocurrenciesViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    AndroidInjection.inject(this)

    cryptocurrenciesViewModel = ViewModelProviders.of(this, cryptocurrenciesViewModelFactory).get(
        CryptocurrenciesViewModel::class.java)

    cryptocurrenciesViewModel.loadCryptocurrencies()

    cryptocurrenciesViewModel.cryptocurrenciesResult().observe(this,
        Observer<List<Cryptocurrency>> {
          hello_world_textview.text = "Hello ${it?.size} cryptocurrencies"
        })

    cryptocurrenciesViewModel.cryptocurrenciesError().observe(this, Observer<String>{
        hello_world_textview.text = "Hello error $it"
      })
  }

  override fun onDestroy() {
    cryptocurrenciesViewModel.disposeElements()
    super.onDestroy()
  }
}
