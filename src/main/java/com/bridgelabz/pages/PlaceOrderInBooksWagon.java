package com.bridgelabz.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;


public class PlaceOrderInBooksWagon {

    WebDriver driver;

    @FindBy(linkText = "Best sellers")
    WebElement bestSeller;

    @FindBy(xpath = "//*[@id=\"listpromoproduct\"]/div[1]/div/a/img")
    WebElement selectBook;

    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ProductDetail_divAddtoCart\"]/a/input")
    WebElement buyNowBtn;

    @FindBy(id = "BookCart_lvCart_ctrl0_txtQty")
    WebElement quantity;

    @FindBy(id = "ctl00_cpBody_txtNewRecipientName")
    WebElement recipientName;

    @FindBy(id = "ctl00_cpBody_txtNewAddress")
    WebElement streetAddress;

    @FindBy(id = "ctl00_cpBody_ddlNewCountry")
    WebElement country;

    @FindBy(name = "ctl00$cpBody$ddlNewState")
    WebElement state;

    @FindBy(id = "ctl00_cpBody_ddlNewCities")
    WebElement city;

    @FindBy(id = "ctl00_cpBody_txtNewPincode")
    WebElement pinCode;

    @FindBy(id = "ctl00_cpBody_txtNewMobile")
    WebElement mobNo;

    @FindBy(id = "ctl00_cpBody_imgSaveNew")
    WebElement saveAndContinueBtn;

    public PlaceOrderInBooksWagon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void orderBook() throws InterruptedException, AWTException {
        bestSeller.click();
        selectBook.click();
        buyNowBtn.click();
        driver.switchTo().frame(0);
        Thread.sleep(200);
        quantity.click();
        Thread.sleep(500);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        Thread.sleep(500);
        quantity.sendKeys("2");
        Thread.sleep(500);
        WebElement placeOrderBtn = driver.findElement(By.name("BookCart$lvCart$imgPayment"));
        placeOrderBtn.click();
        Thread.sleep(2000);
        recipientName.sendKeys("surabhi");
        streetAddress.sendKeys("pune");
        country.sendKeys("India");
        state.sendKeys("Maharashtra");
        city.sendKeys("pune");
        pinCode.sendKeys("411028");
        mobNo.sendKeys("7854963215");
        saveAndContinueBtn.click();
    }
}

