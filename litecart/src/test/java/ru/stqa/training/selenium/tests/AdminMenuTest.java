package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

public class AdminMenuTest extends TestBase {

    @Test
    public void goThroughMenu() {
        app.getAdminHelper().loginAdmin();

     int count = app.driver.findElements(By.cssSelector("li#app-")).size();
     for (int i = 0; i < count; i++) {
         app.driver.findElements(By.cssSelector("li#app-")).get(i).click();
         app.getHelperBase().isElementPresent(By.tagName("h1"));
         int countSubMenu = app.driver.findElements(By.cssSelector("ul.docs > li")).size();
         if (countSubMenu > 0) {
             for (int j =0; j < countSubMenu; j++) {
                 app.driver.findElements(By.cssSelector("ul.docs > li")).get(j).click();
                 app.getHelperBase().isElementPresent(By.tagName("h1"));
             }
         }
     }

    }
}