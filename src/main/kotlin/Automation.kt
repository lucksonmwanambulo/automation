import models.*
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.edge.EdgeDriver
import services.ProductService
import services.RiskCategoryService

import java.time.Duration

class Automation {

    private val productService: ProductService
    private val riskCategoryService: RiskCategoryService
    private var driver: WebDriver = EdgeDriver().apply {
        this["https://iaz.hobbiton.tech/#/dashboard"]
        manage().window().size = Dimension(1454, 1055)
        manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
        manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20))
        manage().timeouts().scriptTimeout(Duration.ofSeconds(20))
    }


    init {
        productService = ProductService(driver)
        riskCategoryService = RiskCategoryService(driver)
    }


    fun login() {
        driver.findElement(By.id("email")).click()
        driver.findElement(By.id("email")).click()
        driver.findElement(By.id("email")).sendKeys("info@iaz.org.zm")
        driver.findElement(By.id("password")).click()
        driver.findElement(By.id("password")).sendKeys("123456")
        driver.findElement(By.cssSelector(".btn")).click()
        Thread.sleep(5000)
        driver.findElement(By.xpath("//li[4]/a/span")).click()
    }


    fun tearDown() {
        driver.quit()
    }

    fun addProducts(products: List<Product>) {
        productService.addProducts(products)
    }

    fun addProduct(product: Product) {
        productService.addProduct(product)
    }


    fun addRisk(
        addRisk: AddRisk,

        ) {
        driver.findElement(By.xpath("//tr[${addRisk.insuranceCompanyIndex}]/td")).click()
        riskCategoryService.addRiskCategory(addRisk)
    }

    fun addRisks(companyId: Int?) {
        if (companyId != null) {
            driver.findElement(By.xpath("//tr[${companyId}]/td")).click()
        }
        riskCategoryService.addRisks(thirdPartyRiskData)
        riskCategoryService.addRisks(actOnlyRiskData)
        riskCategoryService.addRisks(thirdPartyFireRiskData)
        riskCategoryService.addRisks(comprehensiveRiskData)
    }


}