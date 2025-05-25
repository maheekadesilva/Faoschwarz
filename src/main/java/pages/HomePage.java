package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//locators
	private By search_btn = By.xpath("//div[@class='site-nav__icons']/child::a[2]");
	private By search_field = By.xpath("//form[@id='HeaderSearchForm']//input[@name='q']");
	private By search_output_option = By.xpath("//a[@data-content='car']");
	private By close_promo_btn = By.xpath("//button[@aria-label='Close dialog']");
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//close promotional banner
	public void closePromo() {
		WebElement closePromoBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(close_promo_btn));
		closePromoBtn.click();
	}
	
	public void clickSearchBtn() {
		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(search_btn));
		searchBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(search_field));
	}
	
	public void performSearch(String productName) {
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(search_field));
		searchField.sendKeys(productName);
	}
	
	public void clickonSearchOutput() {
		WebElement clickSearchOutput = wait.until(ExpectedConditions.elementToBeClickable(search_output_option));
		clickSearchOutput.click();
	}
}
