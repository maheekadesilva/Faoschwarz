package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResults {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//locators
	private By sort_btn = By.xpath("//div[@class='kuDropdown kuDropSortBy']");
	private By sort_option_price_low = By.xpath("//div[@data-value='PRICE_DESC']");
	private By random_product = By.xpath("(//a[contains(@href, '/products/')])[1]");
	private By close_cookie_banner = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	
	//constructor
	public SearchResults(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//close cookie banner
	public void closeCookieBanner() {
		WebElement closeCookieBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(close_cookie_banner));
		closeCookieBanner.click();
	}
	
	public void performSort() {
		WebElement sortBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(sort_btn));
		Actions action = new Actions(driver);
		action.moveToElement(sortBtn).perform();
		sortBtn.click();
		WebElement selectSortOption = wait.until(ExpectedConditions.visibilityOfElementLocated(sort_option_price_low));
		selectSortOption.click();
	}
		
	public void selectProduct() {		
		WebElement element = driver.findElement(random_product);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

}
