package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test
    public void newRegistration(){
        driver.get("http://litecart.stqa.ru/ru/");
        driver.findElement(By.linkText("New customers click here")).click();
        driver.findElement(By.cssSelector("input[name = tax_id]")).sendKeys("11111");
        driver.findElement(By.cssSelector("input[name = company]")).sendKeys("Stark Industries");
        driver.findElement(By.cssSelector("input[name = firstname]")).sendKeys("Tony");
        driver.findElement(By.cssSelector("input[name = lastname]")).sendKeys("Stark");
        driver.findElement(By.cssSelector("input[name = address1]")).sendKeys("Stark Tower, Manhattan");
        driver.findElement(By.cssSelector("input[name = postcode]")).sendKeys("10001");
        driver.findElement(By.cssSelector("input[name = city]")).sendKeys("New York City");
        WebElement field = driver.findElement(By.className("select2-hidden-accessible"));
        Select select = new Select(field);
        select.selectByVisibleText("United States");
        WebElement field2 = driver.findElement(By.cssSelector("select[name = zone_code]"));
        Select select2 = new Select(field2);
        select2.selectByVisibleText("New York");
        String email = String.format("ironman%s@gmail.com", Math.random());
        driver.findElement(By.cssSelector("input[name = email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name = phone]")).sendKeys("33333");
        driver.findElement(By.cssSelector("input[name = password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name = confirmed_password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name = create_account]")).click();
        driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.cssSelector("input[name = email]")).clear();
        driver.findElement(By.cssSelector("input[name = email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name = password]")).clear();
        driver.findElement(By.cssSelector("input[name = password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name = login]")).click();
        driver.findElement(By.linkText("Logout")).click();




    }
}
