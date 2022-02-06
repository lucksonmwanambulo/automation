import models.*
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.edge.EdgeDriver
import services.ProductService
import services.RiskCategoryService

import java.time.Duration

class Automation {


    private var driver: WebDriver = EdgeDriver().apply {
        this["https://iaz.hobbiton.tech/#/dashboard"]
        manage().window().size = Dimension(1454, 1055)
        manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
        manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20))
        manage().timeouts().scriptTimeout(Duration.ofSeconds(20))
    }


    fun login() {
        driver.findElement(By.id("email")).click()
        driver.findElement(By.id("email")).click()
        driver.findElement(By.id("email")).sendKeys("info@iaz.org.zm")
        driver.findElement(By.id("password")).click()
        driver.findElement(By.id("password")).sendKeys("123456")
        driver.findElement(By.cssSelector(".btn")).click()
        Thread.sleep(10000)
        driver.findElement(By.xpath("//li[4]/a/span")).click()
    }


    fun tearDown() {
        driver.quit()
    }

    fun addThirdPartyProduct(
        product: Product, i: Int,
    ) {
        val productService = ProductService(driver)
        productService.addProduct(product, i)
    }

    fun addRisk(
        addRisk: AddRisk, isSingle: Boolean = true,

        ) {
        val riskCategoryService = RiskCategoryService(driver)
        riskCategoryService.addRiskCategory(addRisk)
    }

    fun addRisks() {
        val riskCategoryService = RiskCategoryService(driver)
        riskCategoryService.addRisks(riskData)
    }


}