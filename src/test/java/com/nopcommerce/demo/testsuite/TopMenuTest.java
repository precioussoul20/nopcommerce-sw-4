package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    TopMenuPage topMenuPage = new TopMenuPage();

    @Test
    public void verifyPageNavigation() {
        topMenuPage.selectMenu("Gift Cards");
    }
}
