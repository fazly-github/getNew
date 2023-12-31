package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest_JUnit {

	
	WebDriver driver;
	@BeforeClass
	public static void beforeClass () {
		System.out.println("Before class");
	}
	@AfterClass
	public static void afterClass() {
		System.out.println("After class");
	}
	
	@After
	public void tearDown() {
		System.out.println("After");
		driver.close();
		driver.quit();
	}
	
	@Before
	public void lunchBrowser() {
		System.out.println("Before");
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		// clear cashe
		driver.manage().deleteAllCookies();
//		go to website
		driver.get("https://techfios.com/billing");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void LoginTest() {
		System.out.println("Login test");
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login1")).click();
		
	}
//	@Test
	public void negLoginTest() {
		System.out.println("negative test");
		driver.findElement(By.id("username")).sendKeys("11demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		
	}

}
