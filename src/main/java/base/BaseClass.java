package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Configuration;

public class BaseClass {
	
	private static final Object IMPLICIT_WAIT = null;

	Configuration config = new Configuration();
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setUpDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.allstate.com/");
		//driver.get(config.getProperties((URL.name()));
		//long pageLoadTime = Long.parseLong(config.getProperties(null).getProperty(IMPLICIT_WAIT.toString()));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((Long) IMPLICIT_WAIT));

		
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod
	public void closingTheSession() {
		getDriver().quit();
		
	}
}
