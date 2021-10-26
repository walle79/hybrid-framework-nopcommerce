package com.nopcommerce.login;

import org.testng.annotations.Test;

import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

import org.testng.annotations.BeforeClass;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class User_01_Register_Login {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		emailAddress = "son" + getRandomEmail();
		password = "123456";
		
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register_To_System() {
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		
		registerPage.clickToMaleRadioBtn();
		registerPage.inputToFirstNameTxt("nguyen");
		registerPage.inputToLastNameTxt("son");
		registerPage.inputToEmailTxt(emailAddress);
		registerPage.inputToPasswordTxt(password);
		registerPage.inputToConfirmPasswordTxt(password);
		registerPage.clickToRegisterBtn();
		
		Assert.assertTrue(registerPage.isSuccessMsgDisplayed());
		
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	}
	
	@Test
	public void TC_02_Login_To_System() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		
		loginPage.inputToEmailTxt(emailAddress);
		loginPage.inputToPasswordTxt(password);
		loginPage.clickToLoginBtn();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
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
	RegisterPageObject registerPage;
	LoginPageObject loginPage;

}
