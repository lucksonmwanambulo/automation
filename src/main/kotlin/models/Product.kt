package models

import kotlin.random.Random

data class Product(
    val premiumRate: Double,
    val levy: Double,
    val minimumRate: Double,
    val maximumRate: Double,
    val code: String,
    val policyPrefix: String,
    val claimsPrefix: String,
    val coverType: CoverType,
    val wordingsPath: String = "/Users/lucksonmwanambulo/Downloads/POL_WRD.pdf",
    val clausesPath: String = "/Users/lucksonmwanambulo/Downloads/POL_WRD.pdf",
)


val range = String.format("%.1f", Random.nextDouble(1.0, 7.0)).toDouble()

val products = arrayListOf(
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "GILTP",
        policyPrefix = "GILP",
        claimsPrefix = "GILC",
        coverType = CoverType.THIRD_PARTY,
    ),
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "GILAC",
        policyPrefix = "GILP",
        claimsPrefix = "GILC",
        coverType = CoverType.ACT_ONLY,
    ),
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "GILCP",
        policyPrefix = "GILP",
        claimsPrefix = "GILC",
        coverType = CoverType.COMPREHENSIVE,
    ),
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "GILTPFT",
        policyPrefix = "GILP",
        claimsPrefix = "GILC",
        coverType = CoverType.THIRD_PARTY_FIRE_AND_THEFT,
    ),
)
