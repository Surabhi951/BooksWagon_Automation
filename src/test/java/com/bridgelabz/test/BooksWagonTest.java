package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.baseclass.TestNgListener;
import com.bridgelabz.pages.BooksWagonLoginPage;
import com.bridgelabz.pages.BooksWagonHomePage;
import com.bridgelabz.pages.PlaceOrderInBooksWagon;
import com.bridgelabz.pages.RegistrationOnToTheBooksWagon;
import com.bridgelabz.utility.DataProviderCredentials;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;

@Listeners(TestNgListener.class)
public class BooksWagonTest extends BaseClass {

    RegistrationOnToTheBooksWagon registration;
    BooksWagonLoginPage login;
    BooksWagonHomePage homePage;

    PlaceOrderInBooksWagon orderBk;

    @BeforeMethod
    public void initialization() {
        setUp();
        registration = new RegistrationOnToTheBooksWagon(driver);
        login = new BooksWagonLoginPage(driver);
        homePage = new BooksWagonHomePage(driver);
        orderBk = new PlaceOrderInBooksWagon(driver);

    }

    @Test(priority = 0)
    public void redirectOnToTheSignUp() throws InterruptedException {
        log.debug("signup");
        String title = registration.redirectOnToTheSignUpScreen();
        Assert.assertEquals("Online BookStore India, Buy Books Online, Buy Book Online India - Bookswagon.com",title);
        log.info("Redirect OnTo The SignUp page");
    }

    @Test(priority = 1)
    public void insertTheDataIntoTheRegistrationForm() {
        log.debug("insertData");
        registration = new RegistrationOnToTheBooksWagon(driver);
        boolean isEnable = registration.enterDataInToTheRegistrationForm();
        Assert.assertEquals(true,isEnable);
        log.info("inserted data successfully");
    }

    @Test(priority = 2,dataProvider = "testLoginData", dataProviderClass = DataProviderCredentials.class)
    public void loginToBookSWagon(String mobileNo,String password) throws InterruptedException {
        log.debug("login");
        login.loginInToTheBooksWagon(mobileNo, password);
        Thread.sleep(1000);
        log.info("login successfully");
    }

    @Test(priority = 3)
    public void searchBookInBooksWagon() throws InterruptedException {
        log.debug("searchData");
        login.loginInToTheBooksWagon("8149281339","Surabhi@12345");
        Thread.sleep(200);
        homePage.searchBook();
        Thread.sleep(500);
        log.info("search data successfully");
    }

    @Test(priority = 4)
    public void addBookInToTheWishlist() throws InterruptedException {
        log.debug("addBook");
        login.loginInToTheBooksWagon("8149281339","Surabhi@12345");
        Thread.sleep(200);
        homePage.addBookInWishlist();
        Thread.sleep(500);
        log.info("add data successfully");
    }

    @Test(priority = 5)
    public void InBooksWagonOrderBook() throws InterruptedException, AWTException {
        log.debug("order book");
        login.loginInToTheBooksWagon("8149281339","Surabhi@12345");
        Thread.sleep(200);
        orderBk.orderBook();
        Thread.sleep(1000);
        log.info("place order book successfully");
    }

    @Test(priority = 6)
    public void performLogOutOperation() throws InterruptedException, AWTException {
        log.debug("log out");
        login.loginInToTheBooksWagon("8149281339","Surabhi@12345");
        Thread.sleep(200);
        homePage.logOutFromBooksWagon();
        Thread.sleep(1000);
        log.info("log out successfully");
    }

    @AfterMethod
    public void tearDown() {
        closeBrowser();
    }
}

