package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AddProductToCartTest extends TestBase {

    @Test
    public void addProductToCart(){
        driver.get("http://litecart.stqa.ru/ru/");
        int i = 0;
        while (i < 3) {
            List<WebElement> ducks = driver.findElements(By.cssSelector("li.product"));
            ducks.get(0).click();
            if (isElementPresent(driver, By.cssSelector("select[name = 'options[Size]'"))) {
                new Select(driver.findElement(By.cssSelector("select[name = 'options[Size]'"))).selectByVisibleText("Small");
            }
            driver.findElement(By.cssSelector("button[name = add_cart_product]")).click();
            wait.until(textToBe(By.cssSelector("#cart-wrapper span.quantity"), Integer.toString(i + 1)));
            driver.findElement(By.linkText("Home")).click();
            i++;
        }
        driver.findElement(By.cssSelector("#cart a.link")).click();
        List<WebElement> ducksInCart = driver.findElements(By.cssSelector(".dataTable  tr td.item"));
        while (ducksInCart.size() > 0) {
            wait.until(elementToBeClickable(By.cssSelector("button[name = remove_cart_item]"))).click();
            wait.until(stalenessOf(ducksInCart.get(0)));
            ducksInCart = driver.findElements(By.cssSelector(".dataTable  tr td.item"));
        }


    }
}
