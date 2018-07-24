package gistframework

import java.util.concurrent.TimeUnit
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.firefox.FirefoxDriver



class WebClient {

    public visitGist() {
        def driver = new FirefoxDriver()

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

        driver.get("https://gist.github.com")

        return driver
    }
}
