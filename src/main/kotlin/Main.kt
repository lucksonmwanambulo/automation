import models.CoverType
import models.Product


fun main() {


    Automation().also {
        it.login()
        val product = Product(
            5.0,
            3.0, 3.0,
            5.0,
            "MG",
            "MGP",
            "MGC",
            CoverType.COMPREHENSIVE,
        )

        it.addRisks()



    }
}