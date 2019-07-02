package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPOM {

private WebDriver driver; 
	
	public AddNewPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[text()='Posts']")  
    private WebElement postlink;
	
	@FindBy(xpath="//a[@href=\"edit-tags.php?taxonomy=post_tag\"]")
	private WebElement taglink;
	
	@FindBy(id="tag-name")
	private WebElement name;
	
	@FindBy(id="tag-slug")
	private WebElement slug;
	
	@FindBy(id="tag-description")
	private WebElement description;
	
	@FindBy(id="submit")
	private WebElement submit;
	
	public void clickPostLink() {
    	this.postlink.click();
    }
	
	public void clickTagLink() {
		this.taglink.click();
	}
	
	public void sendName(String name)
	{
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void sendSlug(String slug)
	{
		this.slug.clear();
		this.slug.sendKeys(slug);
	}
	
	public void sendDescription(String description)
	{
		this.description.clear();
		this.description.sendKeys(description);
	}
	
	public void clickAddNew()
	{
		this.submit.click();
	}
}
