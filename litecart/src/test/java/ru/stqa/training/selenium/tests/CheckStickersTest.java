package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CheckStickersTest extends TestBase {

    @Test
    public void checkStickers() {
        app.driver.get("http://localhost/litecart/en/");
       List<WebElement> ducks = app.driver.findElements(By.cssSelector("li.product"));
       for (WebElement duck : ducks) {
           List<WebElement> sticker = duck.findElements(By.cssSelector("div.sticker"));
           assertEquals(1, sticker.size());
       }
    }
}
