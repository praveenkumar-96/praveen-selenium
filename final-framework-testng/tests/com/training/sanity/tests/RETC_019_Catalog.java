package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.pom.AdminHomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_019_Catalog {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminHome;
	private static Properties properties;
	//private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		adminHome = new AdminHomePOM(driver);
	
		//screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(7000);
		driver.quit();
	}
	@Test(priority=0)
	public void validLoginTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("First");
	}
	@Test(priority=1)
	public void catalogTest() throws InterruptedException {
		AdminHomePOM adminHome = new AdminHomePOM(driver);
		adminHome.clickPostLink();
		Thread.sleep(2000);
		adminHome.clickCatagoryLink();
		Thread.sleep(2000);
		adminHome.clickCheckBox();
		Thread.sleep(2000);
		adminHome.clickBulkAction();
		Thread.sleep(2000);
		adminHome.clickDropDown();
		Thread.sleep(2000);
		adminHome.clickApply();
	}

}
