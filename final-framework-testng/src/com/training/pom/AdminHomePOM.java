package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminHomePOM {
	
private WebDriver driver; 
	
	public AdminHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath="//div[text()='Posts']")  
    private WebElement postlink;
    
    @FindBy(xpath="//a[text()=\"Categories\"]")
    private WebElement catagorylink;
    
    @FindBy(id="cb-select-430")
    private WebElement checkbox;

    @FindBy(xpath="//select[@id=\"bulk-action-selector-bottom\"]")
    private WebElement bulkaction;
    
    @FindBy(id="doaction2")
    private WebElement apply;
    
    public void clickPostLink() {
    	this.postlink.click();
    }
    
    public void clickCatagoryLink() {
    	this.catagorylink.click();
    }
    
    public void clickCheckBox() {
    	this.checkbox.click();
    }
    public void clickBulkAction() {
    	this.bulkaction.click();
    }
    

    @FindBy(id="bulk-action-selector-bottom")
    private WebElement dropDown;
    
    public void clickDropDown() {
 
    	Select dropdown = new Select(dropDown);
    	dropdown.selectByVisibleText("Delete");
    	
    }
    
    public void clickApply() {
    	this.apply.click();
    }
    
  
}
