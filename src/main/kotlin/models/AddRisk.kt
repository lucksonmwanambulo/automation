package models

import kotlin.random.Random

data class AddRisk(
    val amount: Int,
    val quarterIndex: Int,
    val riskCategoryType: RiskCategoryType,
    val coverType: CoverType,
)

val thirdPartyRiskData = listOf(
    AddRisk(
        Random.nextInt(
            120, 190),
        1,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY,
    ),
    AddRisk(
        Random.nextInt(190, 260),
        2,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY,
    ),
    AddRisk(
        Random.nextInt(260, 450),
        3,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY,
    ),
    AddRisk(
        Random.nextInt(460, 500),
        4,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY,
    ),
)
val actOnlyRiskData = listOf(
    AddRisk(
        Random.nextInt(
            120, 190),
        1,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.ACT_ONLY,
    ),
    AddRisk(
        Random.nextInt(190, 260),
        2,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.ACT_ONLY,
    ),
    AddRisk(
        Random.nextInt(260, 450),
        3,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.ACT_ONLY,
    ),
    AddRisk(
        Random.nextInt(460, 500),
        4,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.ACT_ONLY,
    ),
)
val thirdPartyFireRiskData = listOf(
    AddRisk(
        Random.nextInt(
            120, 190),
        1,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY_FIRE_AND_THEFT,
    ),
    AddRisk(
        Random.nextInt(190, 260),
        2,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY_FIRE_AND_THEFT,
    ),
    AddRisk(
        Random.nextInt(260, 450),
        3,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY_FIRE_AND_THEFT,
    ),
    AddRisk(
        Random.nextInt(460, 500),
        4,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.THIRD_PARTY_FIRE_AND_THEFT,
    ),
)


val comprehensiveRiskData = listOf(
    AddRisk(
        Random.nextInt(
            120, 190),
        1,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.COMPREHENSIVE,
    ),
    AddRisk(
        Random.nextInt(190, 260),
        2,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.COMPREHENSIVE,
    ),
    AddRisk(
        Random.nextInt(260, 450),
        3,

        RiskCategoryType.PRIVATE_CAR,
        CoverType.COMPREHENSIVE,
    ),
    AddRisk(
        Random.nextInt(460, 500),
        4,
        RiskCategoryType.PRIVATE_CAR,
        CoverType.COMPREHENSIVE,
    ),
)
