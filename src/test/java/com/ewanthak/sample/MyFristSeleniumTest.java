package com.ewanthak.sample;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyFristSeleniumTest {

	public WebDriver driver;
	public String baseUrl = "https://www.saucedemo.com/";
	
	@BeforeMethod
	public void setup() {
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe" );
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe");	
    	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.get(baseUrl);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void sampleTest() {
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	
}
