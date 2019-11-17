package ru.stqa.training.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver driver;
    public WebDriverWait wait;

    private NavigationHelper navigationHelper;
    private AdminHelper adminHelper;
    private ProductHelper productHelper;
    private HelperBase helperBase;

    public  void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
        navigationHelper = new NavigationHelper(driver);
        adminHelper = new AdminHelper(driver);
        productHelper = new ProductHelper(driver);
        helperBase = new HelperBase(driver);
    }

    public void stop() {
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public AdminHelper getAdminHelper() {
        return adminHelper;
    }

    public ProductHelper getProductHelper() {
        return productHelper;
    }

    public HelperBase getHelperBase() {
        return helperBase;
    }
}
