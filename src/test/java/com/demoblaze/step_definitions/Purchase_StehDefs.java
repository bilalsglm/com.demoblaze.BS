package com.demoblaze.step_definitions;

import com.demoblaze.pages.CartPage;
import com.demoblaze.pages.HomePage;
import io.cucumber.java.en.When;

public class Purchase_StehDefs {

    HomePage homePage=new HomePage();
    CartPage cartPage=new CartPage();
    int expectedPurchaseAmount=0;

    @When("The user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
        expectedPurchaseAmount += homePage.addProduckt(product,category);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }

    @When("The user removes {string} from the cart")
    public void the_user_removes_from_the_cart(String removeProduct) {
        cartPage.removeProduct(removeProduct);
    }
}
