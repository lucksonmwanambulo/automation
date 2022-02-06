package models

enum class CoverType(val coverName: String, val code: String) {

    ACT_ONLY("Act Only", "G-ACO"),
    THIRD_PARTY("Motor Third Party", "G-THP"),
    COMPREHENSIVE("Comprehensive", "G-CMP"),
    THIRD_PARTY_FIRE_AND_THEFT("Third Party Fire & Theft", "G-TFT"),
}