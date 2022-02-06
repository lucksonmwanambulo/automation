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
    val insuranceCompanyIndex: Int,
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
        code = "MGITP",
        policyPrefix = "MGIP",
        claimsPrefix = "MGIC",
        coverType = CoverType.THIRD_PARTY,
        insuranceCompanyIndex = 5,
    ),
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "MGIAC",
        policyPrefix = "MGIP",
        claimsPrefix = "MGIC",
        coverType = CoverType.ACT_ONLY,
        insuranceCompanyIndex = 5,
    ),
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "MGICP",
        policyPrefix = "MGIP",
        claimsPrefix = "MGIC",
        coverType = CoverType.COMPREHENSIVE,
        insuranceCompanyIndex = 5,
    ),
    Product(
        premiumRate = range,
        levy = range,
        minimumRate = range,
        maximumRate = range,
        code = "MGITPFT",
        policyPrefix = "MGIP",
        claimsPrefix = "MGIC",
        coverType = CoverType.THIRD_PARTY_FIRE_AND_THEFT,
        insuranceCompanyIndex = 5,
    ),
)
