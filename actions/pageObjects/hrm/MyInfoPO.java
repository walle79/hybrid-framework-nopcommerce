package pageObjects.hrm;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.hrm.MyInfoPageUI;

public class MyInfoPO extends BasePage {
	WebDriver driver;

	public MyInfoPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openTabAtSidebarByName(String tabName) {
		waitForElementClickable(driver, MyInfoPageUI.TAB_LINK_SIDEBAR_BY_NAME, tabName);
		clickToElement(driver, MyInfoPageUI.TAB_LINK_SIDEBAR_BY_NAME, tabName);
	}

}
