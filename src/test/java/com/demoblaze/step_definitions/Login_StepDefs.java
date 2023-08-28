package com.demoblaze.step_definitions;

import com.demoblaze.pages.LoginPages;
import com.demoblaze.utilities.ConfigurationReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDefs {

    LoginPages loginPages=new LoginPages();
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("The user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPages.login();
    }

    @When("The user enters {string} and {string} and click login button")
    public void the_user_enters_and_and_click_login_button(String username, String password) {
        loginPages.login(username,password);
    }

    @When("The user enters valid username and password")
    public void the_user_enters_valid_username_and_password(Map<String ,String> userinfo) {
        loginPages.login(userinfo.get("username"),userinfo.get("password"));

    }

    @Then("The user verifies invalid access {string}")
    public void the_user_verifies_invalid_access(String expectedMessage) {
        loginPages.verifyPopUpMessage(expectedMessage);

    }


}
