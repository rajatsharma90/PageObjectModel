package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.LaunchPage;
import Reporting.Reporter;

public class LauchPageTestCase {

	private WebDriver driver;
	private String URL;
	private String BrowserType = "Chrome";
	private LaunchPage launchPage;
	private ExtentReports rep=new Reporter().getInsatance();
	private ExtentTest test;

	@BeforeClass
	public void BeforeClass() {

		//test= new ExtentTest("MySecurekid", "description");
		if (BrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\New Webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else {
			System.out.println("Driver is not initialized");
		}
		URL = "https://www.mysecurekid.com";

		launchPage = new LaunchPage(driver);
		test =rep.startTest("MySecurekid");
		test.log(LogStatus.INFO, "Launching "+BrowserType +"Browser");

		driver.get(URL);
		test.log(LogStatus.INFO,"Launching the website");
	}

	@Test(priority=1)
	public void shop() throws InterruptedException {
		launchPage.clickOnshop(driver);	
		test.log(LogStatus.INFO,"Clicked on the Shop tab");
		launchPage.clickOnColour(driver, "Black");
		test.log(LogStatus.INFO,"Select Black Watch");

		String ExpectedURL="https://mysecurekid.com/product/msk-600w/";
		String ActualURL=driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL) ;
		test.log(LogStatus.PASS, "Test Case Passed");
		rep.endTest(test);
		
	}
	@Test(priority=2)
	public void PageTitle() {
		test=rep.startTest("Second Test Case");
		test.log(LogStatus.INFO,"Starting Test Case 2");
		test.log(LogStatus.PASS,"Demo Test");
		
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		rep.flush();
		driver.close();
	}

}
