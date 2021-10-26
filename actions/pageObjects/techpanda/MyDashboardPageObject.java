package pageObjects.techpanda;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.techpanda.MyDashboardPageUI;

public class MyDashboardPageObject extends BasePage {
	private WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyDashboardPageHeaderDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.MYDASHBOARD_HEADER);
		return isElementDisplayed(driver, MyDashboardPageUI.MYDASHBOARD_HEADER);
	}

}
