package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AddNewProductTest extends TestBase {

    @Test
    public void addNewProduct(){
        app.getAdminHelper().loginAdmin();
        app.driver.findElement(By.linkText("Catalog")).click();
        app.driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']")).click();
        int spiderSizeBefore = app.driver.findElements(By.linkText("Spider-Man duck")).size();
        app.driver.findElement(By.linkText("Add New Product")).click();
        app.driver.findElement(By.cssSelector("input[name=status][value = '1']")).click();
        app.driver.findElement(By.cssSelector("input[name = 'name[en]']")).sendKeys("Spider-Man duck");
        String code = "1234" + Math.random();
        app.driver.findElement(By.cssSelector("input[name = code]")).sendKeys(code);
        if (! app.getHelperBase().isElementPresent(By.cssSelector("input[name='categories[]'][value = '1'][checked = checked]"))) {
            app.driver.findElement(By.cssSelector("input[name='categories[]'][value = '1']")).click();
        }
        app.driver.findElement(By.cssSelector("input[name = 'product_groups[]'][value = '1-3']")).click();
        app.driver.findElement(By.cssSelector("input[name = quantity]")).sendKeys("1");
        app.driver.findElement(By.cssSelector("select[name = sold_out_status_id]")).click();
        app.driver.findElement(By.cssSelector("option[value ='']")).click();
        File photo = new File("src/test/resources/spiderman duck.png");
        app.driver.findElement(By.cssSelector("input[name = 'new_images[]']")).sendKeys(photo.getAbsolutePath());
        app.driver.findElement(By.cssSelector("input[name = date_valid_from]")).sendKeys("30/10/2019");
        app.driver.findElement(By.cssSelector("input[name = date_valid_to]")).sendKeys("30/10/2020");
        app.driver.findElement(By.linkText("Information")).click();
        new Select(app.driver.findElement(By.cssSelector("select[name = manufacturer_id]"))).selectByVisibleText("ACME Corp.");
        app.driver.findElement(By.cssSelector("input[name = keywords]")).sendKeys("ducks");
        app.driver.findElement(By.cssSelector("input[name = 'short_description[en]']")).sendKeys("Marvel ducks");
        app.driver.findElement(By.className("trumbowyg-editor")).sendKeys("Marvel ducks");
        app.driver.findElement(By.cssSelector("input[name = 'head_title[en]']")).sendKeys("Spider-Man");
        app.driver.findElement(By.cssSelector("input[name = 'meta_description[en]']")).sendKeys("Spider-Man");
        app.driver.findElement(By.linkText("Prices")).click();
        app.driver.findElement(By.cssSelector("input[name = purchase_price]")).sendKeys("65");
        new Select(app.driver.findElement(By.cssSelector("select[name = purchase_price_currency_code]"))).selectByVisibleText("US Dollars");
        app.driver.findElement(By.cssSelector("input[name = 'prices[USD]']")).sendKeys("65");
        app.driver.findElement(By.cssSelector("input[name = 'gross_prices[USD]']")).sendKeys("10");
        app.driver.findElement(By.cssSelector("button[name = save]")).click();
        app.driver.findElement(By.xpath("//a[@href='http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1']")).click();
        Assert.assertTrue(app.getHelperBase().isElementPresent(By.linkText("Spider-Man duck")));
        int spiderSizeAfter = app.driver.findElements(By.linkText("Spider-Man duck")).size();
        Assert.assertEquals(spiderSizeBefore + 1, spiderSizeAfter);
    }
}
