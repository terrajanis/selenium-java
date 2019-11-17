package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

public class CheckLogsTest extends TestBase {

    @Test
    public void checkLogs(){
        app.getAdminHelper().loginAdmin();
        app.driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        app.driver.findElement(By.linkText("Subcategory")).click();
        List<WebElement> rows = app.driver.findElements(By.cssSelector(".dataTable tr.row"));
        for (int i = 3; i < rows.size(); i++) {
           rows = app.driver.findElements(By.cssSelector(".dataTable tr.row"));
           rows.get(i).findElement(By.cssSelector(".dataTable td:nth-child(3) a")).click();
            for (LogEntry l : app.driver.manage().logs().get("browser").getAll()) {
                ArrayList<String> logs = new ArrayList<>();
                logs.add(l.toString());
                Assert.assertTrue(logs.isEmpty());
            }
            app.driver.navigate().back();
        }
    }
}
