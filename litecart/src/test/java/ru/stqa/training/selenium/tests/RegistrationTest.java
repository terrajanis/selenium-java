package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

public class RegistrationTest extends TestBase {

    @Test
    public void newRegistration(){
        app.driver.get("http://litecart.stqa.ru/ru/");
        app.driver.findElement(By.linkText("New customers click here")).click();
        app.driver.findElement(By.cssSelector("input[name = tax_id]")).sendKeys("11111");
        app.driver.findElement(By.cssSelector("input[name = company]")).sendKeys("Stark Industries");
        app.driver.findElement(By.cssSelector("input[name = firstname]")).sendKeys("Tony");
        app.driver.findElement(By.cssSelector("input[name = lastname]")).sendKeys("Stark");
        app.driver.findElement(By.cssSelector("input[name = address1]")).sendKeys("Stark Tower, Manhattan");
        app.driver.findElement(By.cssSelector("input[name = postcode]")).sendKeys("10001");
        app.driver.findElement(By.cssSelector("input[name = city]")).sendKeys("New York City");
        WebElement field = app.driver.findElement(By.className("select2-hidden-accessible"));
        Select select = new Select(field);
        select.selectByVisibleText("United States");
        WebElement field2 = app.driver.findElement(By.cssSelector("select[name = zone_code]"));
        Select select2 = new Select(field2);
        select2.selectByVisibleText("New York");
        String email = String.format("ironman%s@gmail.com", Math.random());
        app.driver.findElement(By.cssSelector("input[name = email]")).sendKeys(email);
        app.driver.findElement(By.cssSelector("input[name = phone]")).sendKeys("33333");
        app.driver.findElement(By.cssSelector("input[name = password]")).sendKeys("admin");
        app.driver.findElement(By.cssSelector("input[name = confirmed_password]")).sendKeys("admin");
        app.driver.findElement(By.cssSelector("button[name = create_account]")).click();
        app.driver.findElement(By.linkText("Logout")).click();
        app.driver.findElement(By.cssSelector("input[name = email]")).clear();
        app.driver.findElement(By.cssSelector("input[name = email]")).sendKeys(email);
        app.driver.findElement(By.cssSelector("input[name = password]")).clear();
        app.driver.findElement(By.cssSelector("input[name = password]")).sendKeys("admin");
        app.driver.findElement(By.cssSelector("button[name = login]")).click();
        app.driver.findElement(By.linkText("Logout")).click();




    }
}
