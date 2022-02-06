package models

enum class RiskCategoryType(val riskName: String, val riskId: Int) {
    PRIVATE_CAR("Private car", 6),
    MEDIUM("Medium", 2),
    HIGH("High", 3)

}