package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;

public class CartPage extends BasePage {

    public void removeProduct(String removeProduct) {
        cartModule.click();
        BrowserUtils.waitFor(2);
    }
}