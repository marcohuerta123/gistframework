package gistframework

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// Add functions to register hooks and steps to this script.
this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

// Define a world that represents the test environment.
// Hooks can set up and tear down the environment and steps
// can change its state, e.g. store values used by later steps.
class CustomWorld {
    def result
    def driver
    def webClient

    String customMethod() {
        "foo"
    }
}

// Create a fresh new world object as the test environment for each scenario.
// Hooks and steps will belong to this object so can access its properties
// and methods directly.
World {
    new CustomWorld()
}

Given(~/I don't have and Web session/) { ->
    assert 1 == 1
}

When(~/I visit Gist/) { ->
     webClient = new WebClient()

    driver = webClient.visitGist()
}

And(~/I login to Gist with username (.*) and password (.*)/) { String username, String password ->

    WebElement loginField = driver.findElement(By.id("login_field"))
    loginField.sendKeys(username)

    WebElement passwordField = driver.findElement(By.id("password"))
    passwordField.sendKeys(password)


    WebElement loginButton = driver.findElement(By.name("commit"))
    loginButton.click()

}

And(~/I create a new Gist with description (.*)/) { String description ->

    WebElement createGist = driver.findElement(By.xpath("//*[contains(text(),'New gist')]"))
    createGist.click()

    WebElement fileNameField = driver.findElement(By.name("gist[contents][][name]"))
    fileNameField.sendKeys("examplefile.txt")

    WebElement descriptionField = driver.findElement(By.name("gist[description]"))
    descriptionField.sendKeys(description)

    WebElement blobField = driver.findElement(By.cssSelector("div.CodeMirror-lines"))
    blobField.click()
    
}