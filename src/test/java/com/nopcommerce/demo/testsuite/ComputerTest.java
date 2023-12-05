package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComputerTest extends TestBase {

    TopMenuPage topMenuPage = new TopMenuPage();
    ComputerPage computerPage = new ComputerPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // 1.1 Click on Computer Menu.
        topMenuPage.selectMenu("Computers");
        //1.2 Click on Desktop
        computerPage.clickOnDesktops();
        //get list before filter the name
        List<WebElement> beforeFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> beforeFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : beforeFilterNameZtoAList) {
            beforeFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }
        //1.3 Select Sort By position "Name: Z to A"
        computerPage.sortByPosition("Name: Z to A");
        //Get list after filter name
        List<WebElement> afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double> afterFileNameZtoAList = new ArrayList<>();
        for (WebElement nameZtoA : afterFilterNameZtoAList) {
            afterFileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$", "")));
        }
        //1.4 Verify the Product will arrange in Descending order.
        Collections.sort(beforeFileNameZtoAList);
        Assert.assertEquals(beforeFilterNameZtoAList, afterFilterNameZtoAList);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        // 2.1 Click on Computer Menu.
        topMenuPage.selectMenu("Computers");
        //2.2 Click on Desktop
        computerPage.clickOnDesktops();
        //2.3 Select Sort By position "Name: A to Z"
        computerPage.sortByPosition("Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        computerPage.addToCart();
        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = computerPage.verifyBuildYourOwnText();
        Assert.assertEquals(actualText, expectedText);
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        computerPage.selectProcessor("2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        computerPage.selectRam("8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]
        computerPage.selectHDD();
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        computerPage.selectOS();
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander   [+$5.00]"
        computerPage.clickCheckBox1();
        /*//2.11 Verify the price "$1,475.00"
        String expectedText1="$1,475.00";
        String actualText1 = computerPage.verifyPrice();
        Assert.assertEquals(actualText,expectedText);*/
        //2.12 Click on "ADD TO CARD" Button.
        computerPage.addToCart2();
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar , After that close the bar clicking on the cross button
        String expectedText2 = "The product has been added to your shopping cart";
        String actulText2 = computerPage.VerifyProductAdded();
        Assert.assertEquals(actulText2, expectedText2);
        computerPage.clickClose();
        //   2.14	Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        computerPage.moveToShoppingCart();
        computerPage.clickOnGoToCart();
        //2.15 Verify the message "Shopping cart"
        String expectedText3 = "Shopping cart";
        String actualText3 = computerPage.verifyShoppingCartText();
        Assert.assertEquals(expectedText3, actualText3);
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        computerPage.changeQuantity();
        computerPage.clickOnUpdateCartButton();
        //2.17 Verify the Total"$2,950.00
        String actualTotalMessage = computerPage.getTotalText();
        Assert.assertEquals(actualTotalMessage, "$2,950.00", "error");
        // 2.18 click on checkbox “I agree with the terms of service”
        computerPage.clickOnTermsOfServiceCheckBox();
        // 2.19 Click on “CHECKOUT”
        computerPage.clickOnCheckOutButton();
        // 2.20 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeSignInText = computerPage.getWelcomePageSignInText();
        Assert.assertEquals(actualWelcomeSignInText, "Welcome, Please Sign In!", "error");
        //2.21 Click on “CHECKOUT AS GUEST” Tab
        computerPage.clickOnCheckoutAsGuestButton();
        //2.22 Fill the all mandatory field
        computerPage.inputFirstname("Priya");
        computerPage.inputLastname("Patel");
        computerPage.inputEmail("Priya234Patel@gmail.com");
        computerPage.selectCountry("United Kingdom");
        computerPage.inputCity("London");
        computerPage.inputAddress1("12 Downing street");
        computerPage.inputPostalCode("NW5 6JH");
        computerPage.inputPhoneNumber("12345678");
        //2.23 Click on “CONTINUE”
        computerPage.clickOnContinueButton();
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        computerPage.clickOnNextDayAirRadioButton();
        // 2.25 Click on “CONTINUE”
        computerPage.clickOnContinueButton1();
        // 2.26 Select Radio Button “Credit Card”
        computerPage.clickOnCreditCard();
        computerPage.clickOnPaymentContinueButton();
        //2.27 Select “Master card” From Select credit card dropdown
        computerPage.selectCreditCard("Master card");
        //2.28 Fill all the details
        computerPage.inputCardHolderName("Mr Prime Patel");
        computerPage.inputCardNumber("5356 6548 1418 5420");
        computerPage.selectExpireMonth("12");
        computerPage.selectExpireYear("2028");
        computerPage.inputCardCode("598");
        // 2.29 Click on “CONTINUE”
        computerPage.clickOnContinueButton2();
        //2.30 Verify “Payment Method” is “Credit Card”
        String actualCardMessage = computerPage.getCreditCardText();
        Assert.assertEquals(actualCardMessage, "Credit Card", "error");
        // 2.32 Verify “Shipping Method” is “Next Day Air”
        String actualShippingMessage = computerPage.getNextDayAirText();
        Assert.assertEquals(actualShippingMessage, "Next Day Air", "error");
        //2.33 Verify Total is “$2,950.00”
        String actualTotalAmountMessage = computerPage.getTotalAmountText();
        Assert.assertEquals(actualTotalMessage, "$2,950.00", "error");
        //2.34 Click on “CONFIRM”
        computerPage.clickOnConfirmButton();
        //2.35 Verify the Text “Thank You”
        String actualThankYouText = computerPage.getThankYouText();
        Assert.assertEquals(actualThankYouText, "Thank you", "error");
        // 2.36 Verify the message “Your order has been successfully processed!”
        String actualOrderSuccessText = computerPage.getOrderSuccessProcessText();
        Assert.assertEquals(actualOrderSuccessText, "Your order has been successfully processed!", "error");
        // 2.37 Click on “CONTINUE”
        computerPage.clickOnContinueButton3();
        // 2.38 Verify the text “Welcome to our store”
        String actualWelcomeStoreText = computerPage.getWelcomeOurStoreText();
        Assert.assertEquals(actualWelcomeStoreText, "Welcome to our store", "error");
    }
}
