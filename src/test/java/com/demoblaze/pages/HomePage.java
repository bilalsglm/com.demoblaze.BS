package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;

public class HomePage extends BasePage {

    @FindBy(id = "nameofuser")
    public WebElement nameofuser;

    @FindBy(xpath = "//h3[@class='price-container']")
    public WebElement priceText;
    @FindBy(linkText = "Add to cart")
    public WebElement addToCartBtn;



    public void verifyLogin() {
        String actualUserName = nameofuser.getText();
        String expectedUserName = "Welcome " + ConfigurationReader.get("username");
        Assert.assertEquals(expectedUserName, actualUserName);
    }

    public void verifyLogin(String expecteduserName) {
        String actualUserName = nameofuser.getText();
        Assert.assertTrue(actualUserName.contains(expecteduserName));
    }

    public int addProduckt(String produckt, String category) {
        WebElement categoryTab = Driver.get().findElement(By.linkText(category));
        BrowserUtils.waitForClickablility(categoryTab, 5).click();
        WebElement producktselected = Driver.get().findElement(By.linkText(produckt));
        BrowserUtils.scrollToElement(producktselected);
        BrowserUtils.waitForClickablility(producktselected, 5).click();

        //System.out.println("priceText.getText() = " + priceText.getText());

        String[] arrayAmount = priceText.getText().split(" ");
        //System.out.println(Arrays.toString(arrayAmount));

        int listprice = Integer.parseInt(arrayAmount[0].substring(1));

       // System.out.println(listprice);

        addToCartBtn.click();
        BrowserUtils.waitFor(2);

        //Cikan alerti handel edecez
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();

        homeModule.click();
        return listprice;
    }


}
