package ru.stqa.training.selenium.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminHelper extends HelperBase{

    public AdminHelper(WebDriver driver) {
        super(driver);
    }

    public void loginAdmin() {
        driver.get("http://localhost/litecart/admin/login.php");
        type(By.name("username"),"admin");
      type(By.name("password"),"admin");
       click(By.name("remember_me"));
       click(By.name("login"));
    }
}
