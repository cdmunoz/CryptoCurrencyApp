package co.cdmunoz.cryptocurrencyapp.api

import co.cdmunoz.cryptocurrencyapp.model.Cryptocurrency
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

  @GET("ticker/")
  fun getCryptocurrencies(@Query("start") start: String): Observable<List<Cryptocurrency>>
}