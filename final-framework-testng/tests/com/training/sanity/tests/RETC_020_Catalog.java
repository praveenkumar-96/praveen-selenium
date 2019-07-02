package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddNewPOM;
import com.training.pom.AdminHomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_020_Catalog {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminHome;
	private AddNewPOM AddNew;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		adminHome = new AdminHomePOM(driver);
		AddNew = new AddNewPOM(driver);
	
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
	   AddNew.clickPostLink();
	   Thread.sleep(3000);
	   AddNew.clickTagLink();
	   Thread.sleep(3000);
	   AddNew.sendName("Bee");
	   Thread.sleep(3000);
	   AddNew.sendSlug("ABCD");
	   Thread.sleep(3000);
	   AddNew.sendDescription("Hello");
	   Thread.sleep(3000);
	   AddNew.clickAddNew();
   }
	
}
