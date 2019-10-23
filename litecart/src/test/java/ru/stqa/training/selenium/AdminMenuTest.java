package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AdminMenuTest extends TestBase{

    @Test
    public void goThroughMenu(){
        loginAdmin();

        driver.findElement(By.linkText("Appearence")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-template > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-logotype > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Catalog")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-catalog > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-product_groups > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-option_groups > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-manufacturers > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-suppliers > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-delivery_statuses > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-sold_out_statuses > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-quantity_units > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-csv > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Countries")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Currencies")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Customers")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-customers > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-csv > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-newsletter > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Geo Zones")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Languages")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-languages > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-storage_encoding > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Modules")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-jobs > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-customer > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-shipping > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-payment > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-order_total > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-order_success > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-order_action > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Orders")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-orders > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-order_statuses > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Pages")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Reports")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-monthly_sales > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-most_sold_products > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-most_shopping_customers > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Settings")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-store_info > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-defaults > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-general > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-listings > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-images > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-checkout > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-advanced > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-security > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Slides")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Tax")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-tax_classes > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-tax_rates > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Translations")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-search > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-scan > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-csv > a")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("Users")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.linkText("vQmods")).click();
        isElementPresent(driver, By.tagName("h1"));

        driver.findElement(By.cssSelector("#doc-vqmods > a")).click();
        isElementPresent(driver, By.tagName("h1"));

    }
}
