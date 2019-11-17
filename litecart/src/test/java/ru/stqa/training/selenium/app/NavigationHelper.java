package ru.stqa.training.selenium.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);

    }

    public void goToStore() {
        driver.get("http://litecart.stqa.ru/ru/");
    }

    public void returnHome() {
        driver.findElement(By.linkText("Home")).click();
    }

    public void goToCart() {
        driver.findElement(By.cssSelector("#cart a.link")).click();
    }

}
