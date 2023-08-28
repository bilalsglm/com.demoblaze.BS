package com.demoblaze.pages;


import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPages extends BasePage{

    @FindBy(id="login2")
    public WebElement loginHomeBtn;

    @FindBy(id="loginusername")
    public WebElement input_loginusername;

    @FindBy(id="loginpassword")
    public WebElement input_loginpassword;

    @FindBy(css="[onclick='logIn()']")
    public WebElement submitBtn;

    public void login(){
        String username= ConfigurationReader.get("username");
        String password= ConfigurationReader.get("password");

        loginHomeBtn.click();
        input_loginusername.sendKeys(username);
        input_loginpassword.sendKeys(password);
        submitBtn.click();
        BrowserUtils.waitFor(3);
    }

    public void login(String username,String password){

        loginHomeBtn.click();
        input_loginusername.sendKeys(username);
        input_loginpassword.sendKeys(password);
        submitBtn.click();
        BrowserUtils.waitFor(3);
    }

    public void verifyPopUpMessage(String expectedMessage){
        Alert alert= Driver.get().switchTo().alert();
        String actualMessage= alert.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
