package pageUIs.nopcommerce;

public class NopCommerceBasePageUI {
	public static final String DYNAMIC_LINK_BY_NAME = "//a[text()='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME = "//button[text()='%s']";
	public static final String DYNAMIC_MESSAGE_BY_TEXT = "//span[@id='%s' and text()='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String EMAIL_ERROR_MSG = "//div[@class='%s' and contains(string(),'%s')]";
	public static final String DYNAMIC_MY_ACCOUNT_PAGE_BY_NAME = "//div[@class='listbox']//a[contains(string(),'%s')]";
	public static final String DYNAMIC_RADIO_BTN = "//input[@id='%s']";
	public static final String DYNAMIC_DATE_OF_BIRTH = "//select[@name='%s']";
}