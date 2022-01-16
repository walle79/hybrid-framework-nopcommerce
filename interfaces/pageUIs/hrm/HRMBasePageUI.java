package pageUIs.hrm;

public class HRMBasePageUI {
	public static final String DYNAMIC_MENU_PAGE = "//div[@id='mainMenu']//a[string()='%s']";
	public static final String DYNAMIC_BTN_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_ID = "//select[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input";
	public static final String DYNAMIC_RADIO_BY_LABEL = "//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_TABLE_HEADER_BY_ID_AND_NAME = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String DYNAMIC_TABLE_ROW_BY_COLUMN_INDEX_AND_ROW_INDEX = "//table[@id='%s']/tbody/tr[%s]/td[%s]";
	public static final String DYNAMIC_SUCCESS_MESSAGE_VALUE = "//div[@class='inner']/div[contains(text(),'%s')]";
	public static final String FIELD_BY_ID = "//*[@id='%s']";
	public static final String WELCOME_USER_LINK = "//a[@id='welcome']";
	public static final String LOGOUT_LINK = "//div[@id='welcome-menu']//a[text()='Logout']";
	public static final String USERNAME_TEXTBOX = "//input[@id='txtUsername']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='txtPassword']";
	public static final String LOGIN_BTN = "//input[@id='btnLogin']";

}
