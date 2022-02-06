package services

import models.CoverType
import models.Product
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class ProductService(private val driver: WebDriver) {

    fun addProduct(product: Product) {
        driver.findElement(By.xpath("//tr[${product.insuranceCompanyIndex}]/td")).click()
        createNewProduct(product)

    }

    fun addProducts(products: List<Product>) {
        val firstProduct = products.first()
        driver.findElement(By.xpath("//tr[${firstProduct.insuranceCompanyIndex}]/td")).click()

        for (product in products) {
            createNewProduct(product)
            Thread.sleep(10000)
            driver.navigate().refresh()
        }

    }

    private fun createNewProduct(product: Product) {
        driver.findElement(By.linkText("Products")).click()
        driver.findElement(By.xpath("//div/a/i")).click()

        driver.findElement(By.id("iazCode")).click()
        run {
            val dropdown = driver.findElement(By.id("iazCode"))
            dropdown.findElement(By.xpath("//option[. = '${product.coverType.code}']")).click()
        }
        driver.findElement(By.id("name")).click()
        run {
            val dropdown = driver.findElement(By.id("name"))
            dropdown.findElement(By.xpath("//option[. = '${product.coverType.coverName}']")).click()
        }
        driver.findElement(By.id("code")).click()
        driver.findElement(By.id("code")).sendKeys(product.code)
        driver.findElement(By.id("description")).click()
        driver.findElement(By.id("description")).sendKeys(product.coverType.coverName)
        driver.findElement(By.id("premiumName")).click()
        driver.findElement(By.id("premiumName")).sendKeys(product.premiumRate.toString())
        driver.findElement(By.id("levy")).click()
        driver.findElement(By.id("levy")).sendKeys(product.levy.toString())
        driver.findElement(By.id("minimumLimit")).click()
        driver.findElement(By.id("minimumLimit")).sendKeys(product.maximumRate.toString())
        driver.findElement(By.id("maximumLimit")).click()
        driver.findElement(By.id("maximumLimit")).sendKeys(product.maximumRate.toString())
        driver.findElement(By.id("policyNumber")).click()
        driver.findElement(By.id("policyNumber")).sendKeys(product.policyPrefix)
        driver.findElement(By.id("claimNumber")).click()
        driver.findElement(By.id("claimNumber")).sendKeys(product.claimsPrefix)
        driver.findElement(By.xpath("//form/button")).click()

        driver.findElement(By.id("wordingsFile")).sendKeys(product.wordingsPath)
        driver.findElement(By.id("wordingsDescription")).sendKeys("Policy wording")
        driver.findElement(By.xpath("//form/div[2]/button")).click()

        driver.findElement(By.id("clausesFile")).sendKeys(product.clausesPath)

        driver.findElement(By.id("clausesDescription")).sendKeys("Policy clauses")
        driver.findElement(By.xpath("//div[3]/div/div/div/form/div[2]/button")).click()
        addThirdPartyLiabilities(product)
        if (product.coverType == CoverType.COMPREHENSIVE || product.coverType == CoverType.THIRD_PARTY_FIRE_AND_THEFT) {
            addOwnDamage(driver, product.coverType)
        }
    }

    private fun addThirdPartyLiabilities(product: Product) {
        if (product.coverType != CoverType.ACT_ONLY) {
            selectLimitsOfLiabilityPeril()
            driver.findElement(By.id("perilsName")).click()
            run {
                val dropdown = driver.findElement(By.id("perilsName"))
                dropdown.findElement(By.xpath("//option[. = 'Third Party Property Damage or Loss - ZMW 30,000']"))
                    .click()
            }
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Damage")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        }
        selectLimitsOfLiabilityPeril()
        run {
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Injury/Death - ZMW 50,100']")).click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Death")
            driver.findElement(By.xpath("//div[4]/button")).click()
        }
        selectLimitsOfLiabilityPeril()
        run {
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Bodily Injury/Death Per Event - ZMW 100,100']"))
                .click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Event")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
            driver.findElement(By.xpath("//button[2]")).click()
        }
    }

    private fun selectLimitsOfLiabilityPeril() {
        driver.findElement(By.id("perilsType")).click()
        val dropdown = driver.findElement(By.id("perilsType"))
        dropdown.findElement(By.xpath("//option[. = 'Third Party Liability']")).click()
    }

    private fun addOwnDamage(driver: WebDriver, coverType: CoverType) {

        if (coverType == CoverType.THIRD_PARTY_FIRE_AND_THEFT) {
            fireAndTheftPerils(driver)
            return
        }

        run {
            selectOwnDamagePeril(driver)
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Own Damage']")).click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Own damage")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        }


        run {
            selectOwnDamagePeril(driver)
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Accidental Damage or Collision']")).click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Accidental Damage or Collision")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        }


        fireAndTheftPerils(driver)

        run {
            selectOwnDamagePeril(driver)
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Property Damage']")).click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Property Damage")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        }

    }

    private fun fireAndTheftPerils(driver: WebDriver) {
        run {
            selectOwnDamagePeril(driver)
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Fire']")).click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Fire")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        }


        run {
            selectOwnDamagePeril(driver)
            driver.findElement(By.id("perilsName")).click()
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Theft of Vehicle or Accessories']")).click()
            driver.findElement(By.id("perilsDescription")).click()
            driver.findElement(By.id("perilsDescription")).sendKeys("Theft of Vehicle or Accessories")
            driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        }
    }

    private fun selectOwnDamagePeril(driver: WebDriver) {
        driver.findElement(By.id("perilsType")).click()
        val dropdown = driver.findElement(By.id("perilsType"))
        dropdown.findElement(By.xpath("//option[. = 'Own Damage']")).click()
    }
}