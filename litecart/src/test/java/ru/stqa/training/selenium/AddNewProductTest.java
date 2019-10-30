package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AddNewProductTest extends TestBase {

    @Test
    public void addNewProduct(){
        loginAdmin();
        driver.findElement(By.linkText("Catalog")).click();
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']")).click();
        int spiderSizeBefore = driver.findElements(By.linkText("Spider-Man duck")).size();
        driver.findElement(By.linkText("Add New Product")).click();
        driver.findElement(By.cssSelector("input[name=status][value = '1']")).click();
        driver.findElement(By.cssSelector("input[name = 'name[en]']")).sendKeys("Spider-Man duck");
        String code = "1234" + Math.random();
        driver.findElement(By.cssSelector("input[name = code]")).sendKeys(code);
        if (! isElementPresent(driver, By.cssSelector("input[name='categories[]'][value = '1'][checked = checked]"))) {
            driver.findElement(By.cssSelector("input[name='categories[]'][value = '1']")).click();
        }
        driver.findElement(By.cssSelector("input[name = 'product_groups[]'][value = '1-3']")).click();
        driver.findElement(By.cssSelector("input[name = quantity]")).sendKeys("1");
        driver.findElement(By.cssSelector("select[name = sold_out_status_id]")).click();
        driver.findElement(By.cssSelector("option[value ='']")).click();
        File photo = new File("src/test/resources/spiderman duck.png");
        driver.findElement(By.cssSelector("input[name = 'new_images[]']")).sendKeys(photo.getAbsolutePath());
        driver.findElement(By.cssSelector("input[name = date_valid_from]")).sendKeys("30/10/2019");
        driver.findElement(By.cssSelector("input[name = date_valid_to]")).sendKeys("30/10/2020");
        driver.findElement(By.linkText("Information")).click();
        new Select(driver.findElement(By.cssSelector("select[name = manufacturer_id]"))).selectByVisibleText("ACME Corp.");
        driver.findElement(By.cssSelector("input[name = keywords]")).sendKeys("ducks");
        driver.findElement(By.cssSelector("input[name = 'short_description[en]']")).sendKeys("Marvel ducks");
        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Marvel ducks");
        driver.findElement(By.cssSelector("input[name = 'head_title[en]']")).sendKeys("Spider-Man");
        driver.findElement(By.cssSelector("input[name = 'meta_description[en]']")).sendKeys("Spider-Man");
        driver.findElement(By.linkText("Prices")).click();
        driver.findElement(By.cssSelector("input[name = purchase_price]")).sendKeys("65");
        new Select(driver.findElement(By.cssSelector("select[name = purchase_price_currency_code]"))).selectByVisibleText("US Dollars");
        driver.findElement(By.cssSelector("input[name = 'prices[USD]']")).sendKeys("65");
        driver.findElement(By.cssSelector("input[name = 'gross_prices[USD]']")).sendKeys("10");
        driver.findElement(By.cssSelector("button[name = save]")).click();
        driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']")).click();
        Assert.assertTrue(isElementPresent(driver, By.linkText("Spider-Man duck")));
        int spiderSizeAfter = driver.findElements(By.linkText("Spider-Man duck")).size();
        Assert.assertEquals(spiderSizeBefore + 1, spiderSizeAfter);
    }
}
