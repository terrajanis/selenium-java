package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class CountryAndZoneSortTest extends TestBase {

    @Test
    public void countrySort() {
        app.getAdminHelper().loginAdmin();
        app.driver.findElement(By.linkText("Countries")).click();
        List <WebElement> elementsCountries = app.driver.findElements(By.cssSelector(".dataTable td:nth-child(5)"));
        ArrayList <String> countries = new ArrayList<String>();
        for (WebElement element : elementsCountries) {
            countries.add(element.getAttribute("innerText"));
        }

        ArrayList <String> sortedCountries = new ArrayList<String>();
        for (String c : countries) {
            sortedCountries.add(c);
        }
        sort(sortedCountries);

        Assert.assertTrue(countries.equals(sortedCountries));

    }

    @Test
    public void zoneOfCountrySort() {
        app.getAdminHelper().loginAdmin();
        app.driver.findElement(By.linkText("Countries")).click();
        List <WebElement> zones = app.driver.findElements(By.cssSelector(".dataTable td:nth-child(6)"));
            for (int i = 0; i < zones.size(); i++) {
                List <WebElement> tr = app.driver.findElements(By.cssSelector(".row"));
                List <WebElement> td = tr.get(i).findElements(By.tagName("td"));
                if (!(td.get(5).getAttribute("innerText")).equals("0")) {
                    td.get(4).findElement(By.tagName("a")).click();
                    List <WebElement> elementsZones = app.driver.findElements(By.cssSelector(".dataTable td:nth-child(3)"));
                    elementsZones.remove(elementsZones.size()-1);
                    ArrayList <String> zonesOfCountry = new ArrayList<String>();
                    for (WebElement element : elementsZones) {
                        zonesOfCountry.add(element.getAttribute("innerText"));
                    }
                    ArrayList <String> sortedZonesOfCountry = new ArrayList<String>();
                    for (String c : zonesOfCountry) {
                        sortedZonesOfCountry.add(c);
                    }
                    sort(sortedZonesOfCountry);
                    Assert.assertTrue(zonesOfCountry.equals(sortedZonesOfCountry));
                    app.driver.navigate().back();
                }

            }
        }

        @Test
    public void zoneSort() {
            app.getAdminHelper().loginAdmin();
            app.driver.findElement(By.linkText("Geo Zones")).click();
            List <WebElement> countries = app.driver.findElements(By.cssSelector(".dataTable td:nth-child(3)"));
            for (int i = 0; i < countries.size(); i++) {
                List <WebElement> tr = app.driver.findElements(By.cssSelector(".row"));
                List <WebElement> td = tr.get(i).findElements(By.tagName("td"));
                    td.get(2).findElement(By.tagName("a")).click();
                    List <WebElement> elementsZones = app.driver.findElements(By.cssSelector(".dataTable td:nth-child(3) > select > option[selected=selected]"));
                    ArrayList <String> zonesOfCountry = new ArrayList<String>();
                    for (WebElement element : elementsZones) {
                        zonesOfCountry.add(element.getAttribute("innerText"));
                    }
                    ArrayList <String> sortedZonesOfCountry = new ArrayList<String>();
                    for (String c : zonesOfCountry) {
                        sortedZonesOfCountry.add(c);
                    }
                    sort(sortedZonesOfCountry);
                    Assert.assertTrue(zonesOfCountry.equals(sortedZonesOfCountry));
                app.driver.navigate().back();

            }


        }

    }




