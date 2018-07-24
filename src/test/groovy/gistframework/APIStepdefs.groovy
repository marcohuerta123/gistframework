package gistframework

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

class APIWorld {
    def session
    def response
    def body

    String customMethod() {
        "foo"
    }
}

World {
    new APIWorld()
}

Given(~/I don't have an API session/) { ->
    session = new HttpRequest()
}

When(~/I call the gists endpoint/) { ->
    (response, body) = session.getGists()
}