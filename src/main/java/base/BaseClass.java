package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://faoschwarz.com/");
	}
	
	
	@AfterClass
	public void endTest() {
		
		driver.quit();
	}

}
