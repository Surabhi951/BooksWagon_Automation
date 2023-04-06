package com.bridgelabz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class BooksWagonHomePage {

    WebDriver driver;

    @CacheLookup
    @FindBy(linkText = "Book")
    WebElement bookBtn;

    @CacheLookup
    @FindBy(linkText = "Art & Photography")
    WebElement text;

    @CacheLookup
    @FindBy(linkText = "Sapiens")
    WebElement name;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"ctl00_phBody_ProductDetail_divaction\"]/input")
    WebElement addToWishlistBtn;

    @CacheLookup
    @FindBy(id = "ctl00_lblWishlistCount")
    WebElement wishlistBook;

    @CacheLookup
    @FindBy(id = "inputbar")
    WebElement searchBar;

    @CacheLookup
    @FindBy(xpath = "/html/body/form/header/div[1]/div/div[2]/div/div[2]/div[3]")
    WebElement searchInput;


    public BooksWagonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void searchBook() throws InterruptedException {
        searchBar.click();
        Thread.sleep(200);
        searchBar.sendKeys("Shy");
        Thread.sleep(200);
        searchInput.click();
        Thread.sleep(1000);
    }

    public void addBookInWishlist() throws InterruptedException {
        bookBtn.click();
        text.click();
        name.click();
        addToWishlistBtn.click();
        wishlistBook.click();
        Thread.sleep(1000);
    }

    public void logOutFromBooksWagon() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Point coordinate = driver.findElement(By.linkText("surabhi")).getLocation();
        robot.mouseMove((int) coordinate.getX(),(int) coordinate.getY()+120);
        Thread.sleep(5000);
        WebElement logOutBtn = driver.findElement(By.xpath("//*[@id=\"ctl00_lnkbtnLogout\"]"));
        logOutBtn.click();
        Thread.sleep(5000);
    }
}

