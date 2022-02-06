import models.products


fun main() {

    Automation().also {
        it.login()
        it.addProducts(products)
        Thread.sleep(5000)
        it.addRisks(null)
    }
}
