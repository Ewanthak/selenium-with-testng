package com.ewanthak.sample;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
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
		driver.get(baseUrl);

		System.out.println("**************************************");
		System.out.println("scenario 1");
		System.out.println("Thread Id is: " + Thread.currentThread().getId());
		System.out.println("**************************************");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
	}
	
	@Test
	public void login() {
		driver.get(baseUrl);
		System.out.println("**************************************");
		System.out.println("scenario 2");
		System.out.println("Thread Id is: " + Thread.currentThread().getId());
		System.out.println("**************************************");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='header_container']//span[@class='title']")).getText(), "PRODUCTS");
	}
	
	@Test
	public void verifyLoginPage() {
		driver.get(baseUrl);
		System.out.println("**************************************");
		System.out.println("scenario 3");
		System.out.println("Thread Id is: " + Thread.currentThread().getId());
		System.out.println("**************************************");
		Assert.assertEquals(driver.findElement(By.id("user-name")).isDisplayed(),true);
		Assert.assertEquals(driver.findElement(By.id("password")).isDisplayed(),true);
	}
	
	@Test
	public void verifyLockedoutUserError() {
		driver.get(baseUrl);
		System.out.println("**************************************");
		System.out.println("scenario 4");
		System.out.println("Thread Id is: " + Thread.currentThread().getId());
		System.out.println("**************************************");
		driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//h3[@data-test='error']")).getText(), "Epic sadface: Sorry, this user has been locked out.");
	}
	
	
}
