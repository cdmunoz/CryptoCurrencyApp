package co.cdmunoz.cryptocurrencyapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import co.cdmunoz.cryptocurrencyapp.api.ApiClient
import co.cdmunoz.cryptocurrencyapp.api.ApiInterface
import co.cdmunoz.cryptocurrencyapp.model.Cryptocurrency
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class CryptocurrenciesActivity : AppCompatActivity() {

  val compositeDisposable = CompositeDisposable()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    showCryptocurrencies()
  }

  private fun showCryptocurrencies() {
    val cryptocurrenciesResponse = getCryptocurrencies()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())

    val disposableObserver =
        cryptocurrenciesResponse.subscribeWith(object : DisposableObserver<List<Cryptocurrency>>() {
          override fun onComplete() {
          }

          override fun onNext(cryptocurrencies: List<Cryptocurrency>) {
            val listSize = cryptocurrencies.size
            Log.e("ITEMS **** ", listSize.toString())
          }

          override fun onError(e: Throwable) {
            Log.e("ERROR *** ", e.message)
          }

        })

    compositeDisposable.addAll(disposableObserver)

  }

  private fun getCryptocurrencies(): Observable<List<Cryptocurrency>> {
    val retrofit = ApiClient.getClient()
    val apiInterface = retrofit.create(ApiInterface::class.java)
    return apiInterface.getCryptocurrencies("0")
  }

  override fun onDestroy() {
    compositeDisposable.dispose()
    super.onDestroy()
  }
}
