package com.techpanda.login;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.techpanda.HomePageObject;
import pageObjects.techpanda.LoginPageObject;
import pageObjects.techpanda.MyDashboardPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		emailAddress = "son" + getRandomEmail();
		password = "123456";
	}

	@Test
	public void TC_01_Login_Empty_Email_And_Password() {
		homePage = new HomePageObject(driver);
		
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTxt("");
		loginPage.inputToPasswordTxt("");
		loginPage.clickToLoginBtn();
		
		Assert.assertEquals(loginPage.getEmptyErrorEmailMsg(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyErrorPasswordMsg(), "This is a required field.");
	}
	
	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTxt("123@456.790");
		loginPage.inputToPasswordTxt(password);
		loginPage.clickToLoginBtn();
		
		Assert.assertEquals(loginPage.getInvalidErrorEmailMsg(), "Please enter a valid email address. For example johndoe@domain.com.");
	}
	
	@Test(description = "Password less than 6 characters")
	public void TC_03_Login_Invalid_Password() {
        loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTxt(emailAddress);
		loginPage.inputToPasswordTxt("156");
		loginPage.clickToLoginBtn();
		
		Assert.assertEquals(loginPage.getInvalidErrorPasswordMsg(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
	
	@Test(description = "Email not exist in system")
	public void TC_04_Login_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTxt(emailAddress);
		loginPage.inputToPasswordTxt(password);
		loginPage.clickToLoginBtn();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordMsg(), "Invalid login or password.");
	}
	
	@Test
	public void TC_05_Login_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTxt("sablade7@gmail.com");
		loginPage.inputToPasswordTxt("11111111");
		loginPage.clickToLoginBtn();
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordMsg(), "Invalid login or password.");
	}
	
	@Test
	public void TC_06_Login_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);
		
		loginPage.inputToEmailTxt("sablade7@gmail.com");
		loginPage.inputToPasswordTxt(password);
		loginPage.clickToLoginBtn();
		
		myDashboardPage = new MyDashboardPageObject(driver);
		Assert.assertTrue(myDashboardPage.isMyDashboardPageHeaderDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public String getRandomEmail() {
		Random random = new Random();
		return "testing" + random.nextInt(99999) + "@gmail.com";
	}
	
	HomePageObject homePage;
	MyDashboardPageObject myDashboardPage;
	LoginPageObject loginPage;
}
