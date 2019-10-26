package ru.stqa.training.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CampaignsProductTest extends TestBase{

    @Test
    public void checkDuck() {

        driver.get("http://localhost/litecart/en/");
        WebElement duckNameMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//div[@class='name']"));
        String duckNameMainText = duckNameMain.getAttribute("innerText");
        WebElement campaignPriceMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//strong[@class='campaign-price']"));
        String campaignPriceMainText = campaignPriceMain.getAttribute("innerText");
        WebElement regularPriceMain = driver.findElement(By.xpath("//div[@id='box-campaigns']//s[@class='regular-price']"));
        String regularPriceMainText = regularPriceMain.getAttribute("innerText");
        String[] redColor = campaignPriceMain.getCssValue("color").replaceAll("[rgba()]", "").split("\\s*,\\s*");
        String[] greyColor = regularPriceMain.getCssValue("color").replaceAll("[rgba()]", "").split("\\s*,\\s*");
        System.out.println(Arrays.toString(redColor));
        System.out.println(Arrays.toString(greyColor));
        Assert.assertEquals((Integer.parseInt(redColor[1])),(Integer.parseInt(redColor[2])));
        Assert.assertEquals((Integer.parseInt(greyColor[0])),(Integer.parseInt(greyColor[1])),(Integer.parseInt(greyColor[2])));
        Assert.assertTrue(campaignPriceMain.getTagName().equals("strong"));
        Assert.assertTrue(regularPriceMain.getTagName().equals("s"));
        Assert.assertTrue((campaignPriceMain.getSize().height > regularPriceMain.getSize().height) && (campaignPriceMain.getSize().width > regularPriceMain.getSize().width));

        driver.findElement(By.cssSelector("#box-campaigns.box li.product a.link")).click();

        WebElement duckNameProductPage = driver.findElement(By.tagName("h1"));
        String duckNameProductPageText = duckNameProductPage.getAttribute("innerText");
        WebElement campaignPriceProductPage = driver.findElement(By.xpath("//div[@class='information']//strong[@class='campaign-price']"));
        String campaignPriceProductPageText = campaignPriceProductPage.getAttribute("innerText");
        WebElement regularPriceProductPage = driver.findElement(By.xpath("//div[@class='information']//s[@class='regular-price']"));
        String regularPriceProductPageText = regularPriceProductPage.getAttribute("innerText");

        String[] redColor2 = campaignPriceProductPage.getCssValue("color").replaceAll("[rgba()]", "").split("\\s*,\\s*");
        String[] greyColor2 = regularPriceProductPage.getCssValue("color").replaceAll("[rgba()]", "").split("\\s*,\\s*");
        System.out.println(Arrays.toString(redColor2));
        System.out.println(Arrays.toString(greyColor2));
        Assert.assertEquals((Integer.parseInt(redColor2[1])),(Integer.parseInt(redColor2[2])));
        Assert.assertEquals((Integer.parseInt(greyColor2[0])),(Integer.parseInt(greyColor2[1])),(Integer.parseInt(greyColor2[2])));
        Assert.assertTrue(campaignPriceProductPage.getTagName().equals("strong"));
        Assert.assertTrue(regularPriceProductPage.getTagName().equals("s"));
        Assert.assertTrue((campaignPriceProductPage.getSize().height > regularPriceProductPage.getSize().height) && (campaignPriceProductPage.getSize().width > regularPriceProductPage.getSize().width));

        Assert.assertEquals(duckNameMainText, duckNameProductPageText);
        Assert.assertEquals(campaignPriceMainText, campaignPriceProductPageText);
        Assert.assertEquals(regularPriceMainText, regularPriceProductPageText);





    }
}
