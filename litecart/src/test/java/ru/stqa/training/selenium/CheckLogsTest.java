package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckLogsTest extends TestBase {

    @Test
    public void checkLogs(){
        loginAdmin();
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.linkText("Subcategory")).click();
        List<WebElement> rows = driver.findElements(By.cssSelector(".dataTable tr.row"));
        for (int i = 3; i < rows.size(); i++) {
           rows = driver.findElements(By.cssSelector(".dataTable tr.row"));
           rows.get(i).findElement(By.cssSelector(".dataTable td:nth-child(3) a")).click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                ArrayList<String> logs = new ArrayList<>();
                logs.add(l.toString());
                Assert.assertTrue(logs.isEmpty());
            }
            driver.navigate().back();
        }
    }
}
