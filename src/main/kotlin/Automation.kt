import models.Product
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import java.time.Duration

class Automation {

    private var driver: WebDriver = ChromeDriver().apply {
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
    }


    fun tearDown() {
        driver.quit()
    }

    fun addThirdPartyProduct(product: Product, index: Int) {

        driver.findElement(By.xpath("//li[4]/a/span")).click()

        driver.findElement(By.xpath("//tr[$index]/td")).click()
        driver.findElement(By.linkText("Products")).click()
        driver.findElement(By.xpath("//div/a/i")).click()
        driver.findElement(By.id("iazCode")).click()
        run {
            val dropdown = driver.findElement(By.id("iazCode"))
            dropdown.findElement(By.xpath("//option[. = 'G-THP']")).click()
        }
        driver.findElement(By.id("name")).click()
        run {
            val dropdown = driver.findElement(By.id("name"))
            dropdown.findElement(By.xpath("//option[. = 'Motor Third Party']")).click()
        }
        driver.findElement(By.id("code")).click()
        driver.findElement(By.id("code")).sendKeys(product.code)
        driver.findElement(By.id("description")).click()
        driver.findElement(By.id("description")).sendKeys("Motor third party")
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
        driver.findElement(By.id("perilsType")).click()
        run {
            val dropdown = driver.findElement(By.id("perilsType"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Liability']")).click()
        }
        driver.findElement(By.id("perilsName")).click()
        run {
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Property Damage or Loss - ZMW 30,000']")).click()
        }
        driver.findElement(By.id("perilsDescription")).click()
        driver.findElement(By.id("perilsDescription")).sendKeys("Damage")
        driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        driver.findElement(By.id("perilsType")).click()
        run {
            val dropdown = driver.findElement(By.id("perilsType"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Liability']")).click()
        }
        driver.findElement(By.id("perilsName")).click()
        run {
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Injury/Death - ZMW 50,100']")).click()
        }
        driver.findElement(By.id("perilsDescription")).click()
        driver.findElement(By.id("perilsDescription")).sendKeys("Death")
        driver.findElement(By.xpath("//div[4]/button")).click()
        driver.findElement(By.id("perilsType")).click()
        run {
            val dropdown = driver.findElement(By.id("perilsType"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Liability']")).click()
        }
        driver.findElement(By.id("perilsName")).click()
        run {
            val dropdown = driver.findElement(By.id("perilsName"))
            dropdown.findElement(By.xpath("//option[. = 'Third Party Bodily Injury/Death Per Event - ZMW 100,100']"))
                .click()
        }
        driver.findElement(By.id("perilsDescription")).click()
        driver.findElement(By.id("perilsDescription")).sendKeys("Event")
        driver.findElement(By.cssSelector(".btn-brand-02:nth-child(1)")).click()
        driver.findElement(By.xpath("//button[2]")).click()
      
    }

}