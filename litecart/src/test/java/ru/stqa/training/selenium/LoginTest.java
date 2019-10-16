package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

@BeforeMethod
public  void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
}

@Test
    public void loginTest(){
    driver.get("http://localhost/litecart/admin/login.php");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.name("remember_me")).click();
    driver.findElement(By.name("login")).click();
}

    @AfterMethod
    public void stop() {
        driver.quit();
        driver = null;
    }
}
