package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//locators
	private By increast_qty_btn = By.xpath("//button[@aria-label='Increase item quantity by one']");
	private By add_to_cart_btn = By.xpath("//button[@id='AddToCart-']");
	private By product_title = By.xpath("//h1[@class='h2 product-single__title']");
	private By product_price = By.xpath("//span[@class='product__price on-sale']");
	
	//constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void changeQty() {
		WebElement increateQtyBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(increast_qty_btn));
		increateQtyBtn.click();
		increateQtyBtn.click();
	}
	
	public void addProductToCart() {
		WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(add_to_cart_btn));
		addToCartBtn.click();
	}
	
	public String getProductTitle() {
		WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(product_title));
		return productTitle.getText();
	}
	
	public String getProductprice() {
		WebElement productPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(product_price));
		return productPrice.getText();
	}
}
