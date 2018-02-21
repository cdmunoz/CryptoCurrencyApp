package co.cdmunoz.cryptocurrencyapp.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Entity(
    tableName = "cryptocurrency"
)
data class Cryptocurrency(

    @Json(name = "id")
    @PrimaryKey
    val id: String,

    @Json(name = "name")
    val name: String? = null,

    @Json(name = "symbol")
    val symbol: String = "",

    @Json(name = "rank")
    val rank: Int = 0,

    @Json(name = "price_usd")
    val priceUsd: String = "",

    @Json(name = "price_btc")
    val priceBtc: String = "",

    @Json(name = "24h_volume_usd")
    val jsonMember24hVolumeUsd: String = "",

    @Json(name = "market_cap_usd")
    val marketCapUsd: String = "",

    @Json(name = "available_supply")
    val availableSupply: String = "",

    @Json(name = "total_supply")
    val totalSupply: String = "",

    @Json(name = "max_supply")
    val maxSupply: String = "",

    @Json(name = "percent_change_1h")
    val percentChange1h: String = "",

    @Json(name = "percent_change_24h")
    val percentChange24h: String = "",

    @Json(name = "percent_change_7d")
    val percentChange7d: String = "",

    @Json(name = "last_updated")
    val lastUpdated: Long = 0
) : Serializable