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
import com.training.pom.DeletePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_021_Catagory {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AdminHomePOM adminHome;
	private AddNewPOM AddNew;
	private DeletePOM deletePOM;
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
		deletePOM = new DeletePOM(driver);
	
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
	public void CatalogTest() throws InterruptedException {
		deletePOM.clickPostLink();
		Thread.sleep(4000);
		deletePOM.clickTagLink();
		Thread.sleep(4000);
		deletePOM.clickCheckBox();
		Thread.sleep(4000);
		deletePOM.clickBulkActions();
		Thread.sleep(4000);
		deletePOM.clickDropDown();
		Thread.sleep(4000);
		deletePOM.clickApply();
	}

}
