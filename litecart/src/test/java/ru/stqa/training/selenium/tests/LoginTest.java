package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

public class LoginTest extends TestBase {


@Test
    public void loginTest(){
    app.driver.get("http://localhost/litecart/admin/login.php");
    app.driver.findElement(By.name("username")).sendKeys("admin");
    app.driver.findElement(By.name("password")).sendKeys("admin");
    app.driver.findElement(By.name("remember_me")).click();
    app.driver.findElement(By.name("login")).click();
}


}
