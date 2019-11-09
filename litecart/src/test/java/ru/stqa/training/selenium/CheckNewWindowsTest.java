package ru.stqa.training.selenium;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class CheckNewWindowsTest extends TestBase {


    @Test
    public void checkNewWindows() {
        loginAdmin();
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Countries")).click();
        List<WebElement> elementsCountries = driver.findElements(By.cssSelector(".dataTable td:nth-child(7)"));
        elementsCountries.get(0).click();
        List<WebElement> buttons = driver.findElements(By.cssSelector(".fa.fa-external-link"));
        for (int i = 0; i < buttons.size(); i++) {
            String mainWindow = driver.getWindowHandle();
            Set<String> oldWindows = driver.getWindowHandles();
            buttons.get(i).click();
            String newWindow = wait.until(thereAreWindowsOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);


        }
    }

    public ExpectedCondition<String> thereAreWindowsOtherThan(Set<String> oldWindows) {
        return  new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver driver) {
              Set<String> handles = driver.getWindowHandles();
              handles.removeAll(oldWindows);
              return handles.size() > 0 ? handles.iterator().next() : null;
            }
        };
    }
}
