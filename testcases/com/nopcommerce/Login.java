package com.nopcommerce;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class Login extends BaseTest {
	WebDriver driver;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		emailAddress = "ta@gmail.com";
		password = "123456";

		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		homePage.clickToLinkByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
	}
	
	@Test
	public void TC_01_Login_With_Empty_Data() {
		loginPage.clickToButtonByName(driver, "Log in");
		Assert.assertTrue(loginPage.isValidateMessageDisplayed(driver, "Email-error", "Please enter your email"));
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.sendKeyToTextboxByID(driver, "Email", "abcd1234");
		loginPage.sendKeyToTextboxByID(driver, "Password", password);
		loginPage.clickToButtonByName(driver, "Log in");
		Assert.assertTrue(loginPage.isValidateMessageDisplayed(driver, "Email-error", "Wrong email"));
	}
	
	@Test
	public void TC_03_Login_With_Not_Registed_Email() {
		loginPage.refreshCurrentPage(driver);
		loginPage.sendKeyToTextboxByID(driver, "Email", "asfa@gmail.com");
		loginPage.sendKeyToTextboxByID(driver, "Password", password);
		loginPage.clickToButtonByName(driver, "Log in");
		Assert.assertTrue(loginPage.isErrorEmailMsgDisplayed(driver, "message-error validation-summary-errors", "Login was unsuccessful. Please correct the errors and try again.No customer account found"));
	}
	
	@Test
	public void TC_04_Login_With_Registed_Email_And_Blank_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.sendKeyToTextboxByID(driver, "Email", emailAddress);
		loginPage.sendKeyToTextboxByID(driver, "Password", "");
		loginPage.clickToButtonByName(driver, "Log in");
		Assert.assertTrue(loginPage.isErrorEmailMsgDisplayed(driver, "message-error validation-summary-errors", "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect"));
	}
	
	@Test
	public void TC_05_Login_With_Registed_Email_And_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		loginPage.sendKeyToTextboxByID(driver, "Email", emailAddress);
		loginPage.sendKeyToTextboxByID(driver, "Password", "11111111111");
		loginPage.clickToButtonByName(driver, "Log in");
		Assert.assertTrue(loginPage.isErrorEmailMsgDisplayed(driver, "message-error validation-summary-errors", "Login was unsuccessful. Please correct the errors and try again.The credentials provided are incorrect"));
	}
	
	@Test
	public void TC_06_Login_With_Valid_Data() {
		loginPage.refreshCurrentPage(driver);
		loginPage.sendKeyToTextboxByID(driver, "Email", emailAddress);
		loginPage.sendKeyToTextboxByID(driver, "Password", password);
		loginPage.clickToButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.isHomePageSliderDisplayed();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
}
