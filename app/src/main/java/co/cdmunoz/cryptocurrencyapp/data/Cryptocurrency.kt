package co.cdmunoz.cryptocurrencyapp.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.squareup.moshi.Json
import java.io.Serializable

@Entity(
    tableName = "cryptocurrencies"
)
data class Cryptocurrency(

    @Json(name = "id")
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @Json(name = "name")
    @ColumnInfo(name = "name")
    val name: String?,

    @Json(name = "symbol")
    @ColumnInfo(name = "symbol")
    val symbol: String,

    @Json(name = "rank")
    @ColumnInfo(name = "rank")
    val rank: Int,

    @Json(name = "price_usd")
    @ColumnInfo(name = "price_usd")
    val priceUsd: Double?,

    @Json(name = "price_btc")
    @ColumnInfo(name = "price_btc")
    val priceBtc: String?,

    @Json(name = "24h_volume_usd")
    @ColumnInfo(name = "24h_volume_usd")
    val volumeUsd24h: String?,

    @Json(name = "market_cap_usd")
    @ColumnInfo(name = "market_cap_usd")
    val marketCapUsd: String?,

    @Json(name = "available_supply")
    @ColumnInfo(name = "available_supply")
    val availableSupply: String?,

    @Json(name = "total_supply")
    @ColumnInfo(name = "total_supply")
    val totalSupply: String?,

    @Json(name = "max_supply")
    @ColumnInfo(name = "max_supply")
    val maxSupply: String?,

    @Json(name = "percent_change_1h")
    @ColumnInfo(name = "percent_change_1h")
    val percentChange1h: String?,

    @Json(name = "percent_change_24h")
    @ColumnInfo(name = "percent_change_24h")
    val percentChange24h: String?,

    @Json(name = "percent_change_7d")
    @ColumnInfo(name = "percent_change_7d")
    val percentChange7d: String?,

    @Json(name = "last_updated")
    @ColumnInfo(name = "last_updated")
    val lastUpdated: Double
) : Serializable