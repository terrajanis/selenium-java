package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.List;
import java.util.Set;

public class CheckNewWindowsTest extends TestBase {


    @Test
    public void checkNewWindows() {
        app.getAdminHelper().loginAdmin();
        app.driver.manage().window().maximize();
        app.driver.findElement(By.linkText("Countries")).click();
        List<WebElement> elementsCountries = app.driver.findElements(By.cssSelector(".dataTable td:nth-child(7)"));
        elementsCountries.get(0).click();
        List<WebElement> buttons = app.driver.findElements(By.cssSelector(".fa.fa-external-link"));
        for (int i = 0; i < buttons.size(); i++) {
            String mainWindow = app.driver.getWindowHandle();
            Set<String> oldWindows = app.driver.getWindowHandles();
            buttons.get(i).click();
            String newWindow = app.wait.until(thereAreWindowsOtherThan(oldWindows));
            app.driver.switchTo().window(newWindow);
            app.driver.close();
            app.driver.switchTo().window(mainWindow);
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
