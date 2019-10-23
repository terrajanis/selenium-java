package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckStickersTest extends TestBase {

    @Test
    public void checkStickers() {
        driver.get("http://localhost/litecart/en/");
       List<WebElement> ducks = driver.findElements(By.cssSelector("li.product.column.shadow.hover-light"));
       for (WebElement duck : ducks) {
           List<WebElement> sticker = duck.findElements(By.cssSelector("div.sticker"));
           assertEquals(1, sticker.size());
       }
    }
}
