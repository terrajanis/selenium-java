package ru.stqa.training.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.tests.TestBase;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AddProductToCartTest extends TestBase {

    @Test
    public void addProductToCart(){
        app.getNavigationHelper().goToStore();
        app.getProductHelper().addDucksToCart(0, 0, 3, "Small");
        app.getNavigationHelper().goToCart();
        app.getProductHelper().deleteDucksFromCart();

    }

}
