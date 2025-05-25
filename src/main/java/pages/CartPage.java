package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//locators
	private By view_cart = By.xpath("//a[@id='addToCart-btn']");
	private By cart_product_name = By.xpath("//a[@class='cart__item-name']");
	private By cart_product_price = By.xpath("//span[@class='cart__price a_pplr_item_price']");
	
	//constructor
	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void viewCart() {
		WebElement viewCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(view_cart));
		viewCartBtn.click();
	}
	
	public String getProductTitle() {
		WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(cart_product_name));
		return productTitle.getText();
	}
	
	public String getProductprice() {
		WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(cart_product_price));
		return productPrice.getText();
	}
}
