package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {

	WebDriver driver;

	@FindBy(css="#primary-menu > li.menu-item-2514.aligned-left > a")
	WebElement shop;

	@FindBy(css="#content > div.products.products-grid > div > div.col-lg-6.col-md-6.col-sm-6.col-xs-6.grid.product.post-3588.product.type-product.status-publish.has-post-thumbnail.product_cat-smart-watch.product_tag-gps-watch.product_tag-kid-security-watch.product_tag-smart-watch.product_tag-touch-watch.first.instock.taxable.shipping-taxable.purchasable.product-type-variable > div > div.block-inner > div > div > a > span")
	WebElement Black600W;


	public LaunchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnshop(WebDriver driver) throws InterruptedException {

		shop.click();

	}
	public void clickOnColour(WebDriver driver,String colour) {
		if(colour.equalsIgnoreCase("Black")) {
			Black600W.click();		}
	}

}
