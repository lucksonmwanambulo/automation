import models.CoverType
import models.Product

fun main() {
    println("Hello World!")



    Automation().also {
        it.login()
        Thread.sleep(10000)
        val product = Product(5.0, 3.0, 3.0, 5.0, "MG", "MGP", "MGC", CoverType.COMPREHENSIVE)
        it.addThirdPartyProduct(product, 5)
    }
}