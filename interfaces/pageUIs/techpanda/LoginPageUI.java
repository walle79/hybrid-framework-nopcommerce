package pageUIs.techpanda;

public class LoginPageUI {
	public static final String EMAIL_TXT = "//input[@id='email']";
	public static final String PASSWORD_TXT = "//input[@id='pass']";
	public static final String LOGIN_BTN = "//button[@id='send2']";
	public static final String EMPTY_EMAIL_ERR = "//div[@id='advice-required-entry-email']";
	public static final String EMPTY_PASSWORD_ERR = "//div[@id='advice-required-entry-pass']";
	public static final String INVALID_EMAIL_ERR = "//div[@id='advice-validate-email-email']";
	public static final String INVALID_PASSWORD_ERR = "//div[@id='advice-validate-password-pass']";
	public static final String INVALID_EMAIL_OR_PASSWORD_ERR = "//span[contains(text(),'Invalid login or password.')]";

}
