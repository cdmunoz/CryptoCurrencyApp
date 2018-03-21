package co.cdmunoz.cryptocurrencyapp.data.source

import android.util.Log
import co.cdmunoz.cryptocurrencyapp.data.Cryptocurrency
import co.cdmunoz.cryptocurrencyapp.data.source.local.CryptocurrenciesDao
import co.cdmunoz.cryptocurrencyapp.data.source.remote.ApiInterface
import co.cdmunoz.cryptocurrencyapp.utils.Constants
import co.cdmunoz.cryptocurrencyapp.utils.Utils
import io.reactivex.Observable
import javax.inject.Inject


class CryptocurrencyRepository @Inject constructor(val apiInterface: ApiInterface,
    val cryptocurrenciesDao: CryptocurrenciesDao, val utils: Utils) {

  fun getCryptocurrencies(limit: Int, offset: Int): Observable<List<Cryptocurrency>> {
    val hasConnection = utils.isConnectedToInternet()
    var observableFromApi: Observable<List<Cryptocurrency>>? = null
    if (hasConnection){
      observableFromApi = getCryptocurrenciesFromApi()
    }
    val observableFromDb = getCryptocurrenciesFromDb(limit, offset)

    return if (hasConnection) Observable.concatArrayEager(observableFromApi, observableFromDb)
    else observableFromDb
  }

  fun getCryptocurrenciesFromApi(): Observable<List<Cryptocurrency>> {
    return apiInterface.getCryptocurrencies(Constants.START_ZERO_VALUE)
        .doOnNext {
          Log.e("REPOSITORY API * ", it.size.toString())
          for (item in it) {
            cryptocurrenciesDao.insertCryptocurrency(item)
          }
        }
  }

  fun getCryptocurrenciesFromDb(limit: Int, offset: Int): Observable<List<Cryptocurrency>> {
    return cryptocurrenciesDao.queryCryptocurrencies(limit, offset)
        .toObservable()
        .doOnNext {
          //Print log it.size :)
          Log.e("REPOSITORY DB *** ", it.size.toString())
        }
  }
}