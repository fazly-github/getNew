package variousConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		lunchBrowser();
		positiveLoginTest();
		tearDown();
		
		lunchBrowser();
		negLoginTest();
		tearDown();
		
		
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	public static void lunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Omar\\Selenium\\crm\\driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		// clear cashe
		driver.manage().deleteAllCookies();
//		go to website
		driver.get("https://techfios.com/billing");
		
		driver.manage().window().maximize();
		
		//input locators of username and password
		
//		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		
		
	}
	
	public static void positiveLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
	}
	public static void negLoginTest() {
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
	}
}
