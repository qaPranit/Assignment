package com.qa.fitPeo.baseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.fitPeo.pages.HomePage;

import factory.DriverFactory;

public class BaseTest {
	
	public WebDriver driver;
	public DriverFactory df;
	public HomePage hp;
	public Properties prop;
	
	@BeforeMethod
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		hp = new HomePage(driver);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
