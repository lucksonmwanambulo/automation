package models

data class Product(
    val premiumRate: Double,
    val levy: Double,
    val minimumRate:Double,
    val maximumRate: Double,
    val code: String,
    val policyPrefix: String,
    val claimsPrefix: String,
    val wordingsPath: String = "/Users/lucksonmwanambulo/Downloads/POL_WRD.pdf",
    val clausesPath: String = "/Users/lucksonmwanambulo/Downloads/POL_WRD.pdf",
)
