package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePropertyPOM {

private WebDriver driver; 
	
	public DeletePropertyPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class=\"wp-menu-name\"])[7]")
	private WebElement property;
	
	@FindBy(xpath="(//a[@href=\"edit.php?post_type=property\"])[2]")
	private WebElement Allproperities;
	
	@FindBy(xpath="(//a[text()=\"title\"])[1]")
	private WebElement propertyname;
	
	@FindBy(xpath="//a[@aria-label='Move “prestige4777” to the Trash']")
	private WebElement trash;
	
	
}
