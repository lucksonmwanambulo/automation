import models.*
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.edge.EdgeDriver
import services.ProductService
import services.RiskCategoryService

import java.time.Duration

class Automation {

    private var companyName: String = ""
    private val productService: ProductService
    private val riskCategoryService: RiskCategoryService

    private var driver: WebDriver = EdgeDriver().apply {
        this["https://iaz.hobbiton.tech"]
        manage().window().size = Dimension(1454, 1055)
        manage().timeouts().implicitlyWait(Duration.ofSeconds(20))
        manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20))
        manage().timeouts().scriptTimeout(Duration.ofSeconds(20))
    }


    init {
        productService = ProductService(driver)
        riskCategoryService = RiskCategoryService(driver)
    }


    fun addProductAndRisksRange(start: Int, end: Int, isOnNextPage: Boolean = false) {
        login()
        for (i in start..end) {
            addProductAndRisks(i, isOnNextPage)
        }
    }

    fun addProductAndRisks(companyIndex: Int, isOnNextPage: Boolean = false) {
        if (isOnNextPage) {
            driver.findElement(By.xpath("//a[@id=\'insurance_next\']")).click()
            Thread.sleep(5000)
        }
        driver.findElement(By.xpath("//tr[${companyIndex}]/td")).click()
        companyName = driver.findElement(By.id("companyName")).text
        addProducts(products.map {
            it.copy(
                claimsPrefix = generateCompanyCode() + "C",
                policyPrefix = generateCompanyCode() + "P",
                code = generateProductCode(it.coverType),
            )
        })
        Thread.sleep(5000)
        addRisks(null)
        driver.navigate().refresh()
        Thread.sleep(5000)
        driver.findElement(By.xpath("//li[4]/a/span")).click()
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

    private fun addProducts(products: List<Product>) {
        productService.addProducts(products)
    }



    private fun addRisks(companyId: Int?) {
        if (companyId != null) {
            driver.findElement(By.xpath("//a[@id=\'insurance_next\']")).click()
            Thread.sleep(5000)
            driver.findElement(By.xpath("//tr[${companyId}]/td")).click()
        }

        for (i in 6 downTo 2) {
            riskCategoryService.addRisks(thirdPartyRiskData, i)
            riskCategoryService.addRisks(actOnlyRiskData, i)
            riskCategoryService.addRisks(thirdPartyFireRiskData, i)
            riskCategoryService.addRisks(comprehensiveRiskData, i)
        }

    }

    private fun generateCompanyCode(): String {
        return companyName.split(" ").take(3).map { it[0].uppercaseChar() }.joinToString("")
    }

    private fun generateProductCode(coverType: CoverType): String {
        return when (coverType) {
            CoverType.THIRD_PARTY -> generateCompanyCode() + "TP"
            CoverType.ACT_ONLY -> generateCompanyCode() + "AO"
            CoverType.THIRD_PARTY_FIRE_AND_THEFT -> generateCompanyCode() + "TF"
            CoverType.COMPREHENSIVE -> generateCompanyCode() + "C"
        }
    }


}