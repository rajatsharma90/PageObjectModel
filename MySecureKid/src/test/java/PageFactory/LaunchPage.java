package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
	
	 WebDriver driver;
	
@FindBy(xpath= "//*[@id=primary-menu]/li[4]/a")
	WebElement shop;

@FindBy(xpath="//*[@id=content]/div[2]/div/div[3]/div/div[3]/div[2]/div/a[3]/img")
WebElement Pink400T;


public LaunchPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickOnshop(WebDriver driver) {
	shop.click();

	}
public void clickOnColour(WebDriver driver,String colour) {
	if(colour.equalsIgnoreCase("pink")) {
		Pink400T.click();
	}
}

}
