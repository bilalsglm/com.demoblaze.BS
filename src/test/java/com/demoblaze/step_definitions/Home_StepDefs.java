package com.demoblaze.step_definitions;

import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.Then;

public class Home_StepDefs {
    HomePage homePage=new HomePage();
    @Then("The user verify welcome miky")
    public void the_user_verify_welcome_miky() {
        homePage.verifyLogin();
    }

    @Then("The user verifies welcome {string}")
    public void the_user_verifies_welcome(String expecteduserName) {
        homePage.verifyLogin(expecteduserName);

    }



}
