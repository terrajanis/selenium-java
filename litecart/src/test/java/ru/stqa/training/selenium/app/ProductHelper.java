package ru.stqa.training.selenium.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class ProductHelper extends HelperBase {

    NavigationHelper navigationHelper = new NavigationHelper(driver);


    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> allDucks() {
        return driver.findElements(By.cssSelector("li.product"));
    }

    public boolean checkChosingSize() {
        return isElementPresent(By.cssSelector("select[name = 'options[Size]'"));
    }

    public void choseSize(String size) {
        new Select(driver.findElement(By.cssSelector("select[name = 'options[Size]'"))).selectByVisibleText(size);
    }

    public void addProductToCart(int i) {
        driver.findElement(By.cssSelector("button[name = add_cart_product]")).click();
        wait.until(textToBe(By.cssSelector("#cart-wrapper span.quantity"), Integer.toString(i + 1)));
    }

    public void addDucksToCart(int i, int duckInList, int numberOfDucks, String size) {
        while (i < numberOfDucks) {
            List<WebElement> ducks = allDucks();
            ducks.get(duckInList).click();
            if (checkChosingSize()) {
               choseSize(size);
            }
           addProductToCart(i);
            navigationHelper.returnHome();
            i++;
        }
    }

    public void deleteDucksFromCart() {
        List<WebElement> ducksInCart = allProductsInCart();
        while (ducksInCart.size() > 0) {
            removeProductFromCart(ducksInCart, 0);
            ducksInCart = allProductsInCart();
        }
    }

    public List<WebElement> allProductsInCart() {
        return driver.findElements(By.cssSelector(".dataTable  tr td.item"));
    }

    public void removeProductFromCart(List<WebElement> products, int i) {
        wait.until(elementToBeClickable(By.cssSelector("button[name = remove_cart_item]"))).click();
        wait.until(stalenessOf(products.get(i)));
    }
}
