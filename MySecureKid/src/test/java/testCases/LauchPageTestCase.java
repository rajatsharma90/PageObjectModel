package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageFactory.LaunchPage;

public class LauchPageTestCase {

	private WebDriver driver;
	private String URL;
	private String BrowserType = "Chrome";
	private LaunchPage launchPage;

	@BeforeClass
	public void BeforeClass() {
		if (BrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\New Webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (BrowserType.equalsIgnoreCase("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", "D:\\New Webdrivers\\geckodriver.exe");
			driver = new ChromeDriver();
		}
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		} else
			System.out.println("Driver is not initialized");
		URL = "https://www.mysecurekid.com";

		driver = new ChromeDriver();
		launchPage = new LaunchPage(driver);

		driver.get(URL);
	}

	@Test
	public void shop() {
launchPage.clickOnshop(driver);		
launchPage.clickOnColour(driver, "pink");
	}

}
