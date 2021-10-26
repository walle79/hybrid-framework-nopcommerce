package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTxt(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TXT);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TXT, email);
	}

	public void inputToPasswordTxt(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TXT);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TXT, password);
	}

	public void clickToLoginBtn() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
		clickToElement(driver, LoginPageUI.LOGIN_BTN);
	}

	public String getEmptyErrorEmailMsg() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERR);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERR);
	}

	public String getEmptyErrorPasswordMsg() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERR);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERR);
	}

	public String getInvalidErrorEmailMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_ERR);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERR);
	}

	public String getInvalidErrorPasswordMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERR);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERR);
	}

	public String getInvalidEmailOrPasswordMsg() {
		waitForElementVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERR);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERR);
	}

}
