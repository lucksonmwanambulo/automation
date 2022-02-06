import kotlinx.coroutines.runBlocking
import models.products


fun main(): Unit = runBlocking{

    Automation().also {
        it.login()
        it.addProductAndRisksRange(1,10,false)
    }
}
