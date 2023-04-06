package com.bridgelabz.pages;

import com.bridgelabz.utility.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BooksWagonLoginPage extends ReadPropertyFile {

    WebDriver driver;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignIn$txtEmail")
    WebElement mobileNo;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignIn$txtPassword")
    WebElement password;

    @CacheLookup
    @FindBy(linkText = "Login")
    WebElement loginButton;

    public BooksWagonLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loginInToTheBooksWagon(String mobNo, String pass) throws InterruptedException {
        driver.findElement(By.name(properties.getProperty("loginMobileNumberData"))).sendKeys(mobNo);
        password.sendKeys(pass);
        loginButton.click();
        Thread.sleep(500);
        redirectOnToTheHomePage();
        Thread.sleep(500);
    }

    public void redirectOnToTheHomePage() {
        String title = driver.getTitle();
        Assert.assertEquals("Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com",title);
    }
}
