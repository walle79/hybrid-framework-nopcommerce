package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMaleRadioBtn() {
		waitForElementClickable(driver, RegisterPageUI.MALE_RADIO_BTN);
		clickToElement(driver, RegisterPageUI.MALE_RADIO_BTN);
	}

	public void inputToFirstNameTxt(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TXT);
		sendKeyToElement(driver, RegisterPageUI.FIRSTNAME_TXT, firstName);
	}

	public void inputToLastNameTxt(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TXT);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TXT, lastName);
	}

	public void inputToEmailTxt(String email) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TXT);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TXT, email);
	}

	public void clickToRegisterBtn() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BTN);
		clickToElement(driver, RegisterPageUI.REGISTER_BTN);
	}

	public void inputToPasswordTxt(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TXT, password);
	}

	public void inputToConfirmPasswordTxt(String confirmPassword) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TXT);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TXT, confirmPassword);
	}

	public boolean isSuccessMsgDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MSG);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MSG);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
