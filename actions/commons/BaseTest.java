package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;
	private String projectLocation = System.getProperty("user.dir");
	
	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Invalid browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectLocation + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectLocation + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			throw new RuntimeException("Invalid browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appUrl);
		driver.manage().window().maximize();
		return driver;
	}

}
