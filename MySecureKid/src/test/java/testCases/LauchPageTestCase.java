package testCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	Logger log=Logger.getLogger("LaunchPageTestCase");
	

	@BeforeClass
	public void BeforeClass() {
	
		PropertyConfigurator.configure("log4j.properties");

	
		if (BrowserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\New Webdrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else {
			System.out.println("Driver is not initialized");
		}
		URL = "https://www.mysecurekid.com";
log.info("Browser Opened");
		launchPage = new LaunchPage(driver);
		test =rep.startTest("MySecurekid");
		test.log(LogStatus.INFO, "Launching "+BrowserType +"Browser");
log.info("Opening Mysecurekid.com");


		driver.get(URL);
		log.info("URL Opened");
		test.log(LogStatus.INFO,"Launching the website");
	}

	@Test(priority=1)
	public void shop() throws InterruptedException {
		launchPage.clickOnshop(driver);	
		log.info("Clicked on shop");
		test.log(LogStatus.INFO,"Clicked on the Shop tab");
		log.info("MSK 600W clicked");
		launchPage.clickOnColour(driver, "Black");
		test.log(LogStatus.INFO,"Select Black Watch");

		String ExpectedURL="https://mysecurekid.com/product/msk-600w/";
		log.info(ExpectedURL +"should be the page's url");
		String ActualURL=driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL) ;
	//	test.log(LogStatus.PASS, "Test Case Passed");
		log.assertLog(true, "The URL's match");
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
