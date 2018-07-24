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

        driver.get("https://github.com/login?client_id=7e0a3cd836d3e544dbd9&return_to=%2Flogin%2Foauth%2Fauthorize%3Fclient_id%3D7e0a3cd836d3e544dbd9%26redirect_uri%3Dhttps%253A%252F%252Fgist.github.com%252Fauth%252Fgithub%252Fcallback%253Freturn_to%253Dhttps%25253A%25252F%25252Fgist.github.com%25252Fdiscover%26response_type%3Dcode%26state%3Df12af284be3e062290d3fb6e376e8051d2ce507c760a1798833ab42666a3131f")

        return driver
    }
}
