package models

data class AddRisk(
    val amount: Double,
    val insuranceCompanyIndex: Int,
    val quarterIndex: Int,
    val riskCategoryType: RiskCategoryType,
    val coverType: CoverType,
)

val riskData = listOf(
    AddRisk(140.0, 8, 1, RiskCategoryType.PRIVATE_CAR, CoverType.THIRD_PARTY),
    AddRisk(180.0, 8, 2, RiskCategoryType.PRIVATE_CAR, CoverType.THIRD_PARTY),
    AddRisk(300.0, 8, 3, RiskCategoryType.PRIVATE_CAR, CoverType.THIRD_PARTY),
    AddRisk(400.0, 8, 4, RiskCategoryType.PRIVATE_CAR, CoverType.THIRD_PARTY),
    )
