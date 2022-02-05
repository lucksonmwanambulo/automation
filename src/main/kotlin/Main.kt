import models.Product

fun main(args: Array<String>) {
    println("Hello World!")



    Automation().also {
        it.login()
        Thread.sleep(10000)
        val product = Product(5.0, 3.0, 3.0, 5.0, "AGI", "AGIP", "AGIC")
        it.addThirdPartyProduct(product,6)
    }
}