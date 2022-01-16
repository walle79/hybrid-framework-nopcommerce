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
import pageObjects.nopcommerce.MyAccountPageObject;
import pageObjects.nopcommerce.PageGeneratorManager;
import pageObjects.nopcommerce.RegisterPageObject;

public class MyAccount extends BaseTest {
	WebDriver driver;
	String editFirstName, editLastName, editEmail, editCompanyName, editGenderName, emailAddress, password;
	String editDateOfBirthDay, editDateOfBirthMonth, editDateOfBirthYear;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);

		// Data test
		editFirstName = "Automation";
		editLastName = "FC";
		editEmail = "automationfc.vn@gmail.com";
		editCompanyName = "Automation FC";
		editGenderName = "F";
		editDateOfBirthDay = "1";
		editDateOfBirthMonth = "January";
		editDateOfBirthYear = "1999";
		emailAddress = "ta@gmail.com";
		password = "123456";

		homePage = PageGeneratorManager.getHomePage(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		// Navigate to 'Log in' page
		homePage.clickToLinkByName(driver, "Log in");
		loginPage = PageGeneratorManager.getLoginPage(driver);
		
		// Login with email and password registered
		loginPage.sendKeyToTextboxByID(driver, "Email", emailAddress);
		loginPage.sendKeyToTextboxByID(driver, "Password", password);
		loginPage.clickToButtonByName(driver, "Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.isHomePageSliderDisplayed();
		
		// Navigate to 'My account' page
		homePage.clickToLinkByName(driver, "My account");
		myAccountPage = PageGeneratorManager.getMyAccountPage(driver);
	}
	
	@Test
	public void TC_01_Customer_Info() {
		// Open 'Customer info' page
		myAccountPage.openMyAccountPageByName(driver, "Customer info");
		// Verify email registered is correct
		Assert.assertEquals(myAccountPage.getElementAttributeValue(driver, "Email", "value"), emailAddress);
		
		// Update information
		myAccountPage.clickToRadioGenderButton(driver, "gender-female");
		myAccountPage.sendKeyToTextboxByID(driver, "FirstName", editFirstName);
		myAccountPage.sendKeyToTextboxByID(driver, "LastName", editLastName);
		myAccountPage.selectDateOfBirthDropdownByText(driver, "DateOfBirthDay", editDateOfBirthDay);
		myAccountPage.selectDateOfBirthDropdownByText(driver, "DateOfBirthMonth", editDateOfBirthMonth);
		myAccountPage.selectDateOfBirthDropdownByText(driver, "DateOfBirthYear", editDateOfBirthYear);
		// myAccountPage.sendKeyToTextboxByID(driver, "Email", editEmail);
		myAccountPage.sendKeyToTextboxByID(driver, "Company", editCompanyName);
		myAccountPage.clickToButtonByName(driver, "Save");
		
		// Verify information updated
		Assert.assertEquals(myAccountPage.getElementAttributeValue(driver, "gender-female", "value"), editGenderName);
		Assert.assertEquals(myAccountPage.getElementAttributeValue(driver, "FirstName", "value"), editFirstName);
		Assert.assertEquals(myAccountPage.getElementAttributeValue(driver, "LastName", "value"), editLastName);
		Assert.assertEquals(myAccountPage.getDateOfBirthSelectedItemDropdownByText(driver, "DateOfBirthDay"), editDateOfBirthDay);
		Assert.assertEquals(myAccountPage.getDateOfBirthSelectedItemDropdownByText(driver, "DateOfBirthMonth"), editDateOfBirthMonth);
		Assert.assertEquals(myAccountPage.getDateOfBirthSelectedItemDropdownByText(driver, "DateOfBirthYear"), editDateOfBirthYear);
		// Assert.assertEquals(myAccountPage.getElementAttributeValue(driver, "Email", "value"), editEmail);
		Assert.assertEquals(myAccountPage.getElementAttributeValue(driver, "Company", "value"), editCompanyName);
	}
	
	@Test
	public void TC_02_Addresses() {

	}
	
	@Test
	public void TC_03_Change_Password() {

	}
	
	@Test
	public void TC_04_My_Product_Reviews() {
		
	}

	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
}

