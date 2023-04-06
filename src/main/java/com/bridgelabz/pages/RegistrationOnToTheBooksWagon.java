package com.bridgelabz.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationOnToTheBooksWagon {

    WebDriver driver;

    @CacheLookup
    @FindBy(linkText = "New to Bookswagon? Sign up")
    WebElement signUpLink;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignUp$txtName")
    WebElement name;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignUp$txtEmail")
    WebElement mobileNo;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignUp$btnContinue")
    WebElement contiueBtn;

    @CacheLookup
    @FindBy(id = "ctl00_phBody_SignUp_txtOTP")
    WebElement otp;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignUp$txtPassword")
    WebElement password;

    @CacheLookup
    @FindBy(name = "ctl00$phBody$SignUp$txtConfirmPwd")
    WebElement confirmPwd;

    @CacheLookup
    @FindBy(linkText = "Sign up")
    WebElement signUpButton;

    public RegistrationOnToTheBooksWagon(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String redirectOnToTheSignUpScreen() throws InterruptedException {
        signUpLink.click();
        Thread.sleep(100);
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean enterDataInToTheRegistrationForm() {
        signUpLink.click();
        name.sendKeys("surabhi");
        mobileNo.sendKeys("8745963216");
        contiueBtn.click();
        otp.sendKeys("723685");
        password.sendKeys("Surabhi@12345");
        confirmPwd.sendKeys("Surabhi@12345");
        boolean flag = signUpButton.isEnabled();
        return flag;
    }
}
