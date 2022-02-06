package services

import models.AddRisk
import models.RiskCategoryType
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class RiskCategoryService(private val driver: WebDriver) {


    fun addRiskCategory(
        addRisk: AddRisk,
    ) {

        driver.findElement(By.linkText("Risk Category")).click()
        driver.findElement(By.xpath("//a[${addRisk.riskCategoryType.riskId}]")).click()

        driver.findElement(By.xpath("//div[3]/div/div/div/div/div/a/i")).click()
        run {
            driver.findElement(By.id("rate_product")).click()
            val dropdown = Select(driver.findElement(By.id("rate_product")))
            dropdown.selectByVisibleText(addRisk.coverType.coverName)
        }
        selectCoverType(addRisk)
        run {
            val dropdown: WebElement = driver.findElement(By.id("rate_quarter"))
            dropdown.findElement(By.xpath("//option[. = '${addRisk.quarterIndex}']")).click()
        }
        driver.findElement(By.id("rate_premium")).click()
        driver.findElement(By.id("rate_premium")).sendKeys(addRisk.amount.toString())
        driver.findElement(By.cssSelector("#basicRate > .btn")).click()
    }

    fun addRisks(risks: List<AddRisk>) {
        try {
            val first = risks.first()
            driver.findElement(By.linkText("Risk Category")).click()
            driver.findElement(By.xpath("//a[${first.riskCategoryType.riskId}]")).click()
            for (risk in risks) {
                run {
                    driver.findElement(By.xpath("//div[3]/div/div/div/div/div/a/i")).click()
                    driver.findElement(By.id("rate_product")).click()
                    val dropdown = Select(driver.findElement(By.id("rate_product")))
                    dropdown.selectByVisibleText(risk.coverType.coverName)
                }

                run {
                    selectCoverType(risk)
                    val dropdown: WebElement = driver.findElement(By.id("rate_quarter"))
                    dropdown.findElement(By.xpath("//option[. = '${risk.quarterIndex}']")).click()
                }
                driver.findElement(By.id("rate_premium")).click()
                driver.findElement(By.id("rate_premium")).sendKeys(risk.amount.toString())
                driver.findElement(By.cssSelector("#basicRate > .btn")).click()
                Thread.sleep(5000)
            }
        } catch (e: Exception) {
            println("Risk Category Service Exception: ${e.message}")
            driver.navigate().refresh()
            Thread.sleep(5000)

        }

    }

    private fun selectCoverType(risk: AddRisk) {
        driver.findElement(By.id("rate_name")).click()
        driver.findElement(By.id("rate_name")).sendKeys(risk.coverType.coverName)
        driver.findElement(By.id("rate_description")).click()
        driver.findElement(By.id("rate_description")).sendKeys(risk.coverType.coverName)
        driver.findElement(By.id("rate_quarter")).click()
    }

}