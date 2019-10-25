package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AdminMenuTest extends TestBase {

    @Test
    public void goThroughMenu() {
        loginAdmin();

     int count = driver.findElements(By.cssSelector("li#app-")).size();
     for (int i = 0; i < count; i++) {
         driver.findElements(By.cssSelector("li#app-")).get(i).click();
         isElementPresent(driver, By.tagName("h1"));
         int countSubMenu = driver.findElements(By.cssSelector("ul.docs > li")).size();
         if (countSubMenu > 0) {
             for (int j =0; j < countSubMenu; j++) {
                 driver.findElements(By.cssSelector("ul.docs > li")).get(j).click();
                 isElementPresent(driver, By.tagName("h1"));
             }
         }
     }

    }
}