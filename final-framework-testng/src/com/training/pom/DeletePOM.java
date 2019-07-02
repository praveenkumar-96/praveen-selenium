package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeletePOM {

private WebDriver driver; 
	
	public DeletePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Posts']")  
    private WebElement postlink;
	
	@FindBy(xpath="//a[@href=\"edit-tags.php?taxonomy=post_tag\"]")
	private WebElement taglink;
	
	@FindBy(id="cb-select-450")
	private WebElement checkbox;
	
	@FindBy(id="bulk-action-selector-bottom")
	private WebElement bulkactions;
	
	 @FindBy(id="bulk-action-selector-bottom")
	  private WebElement dropDown;
	 
	 @FindBy(id="doaction2")
	 private WebElement Apply;
	 
	 public void clickPostLink() {
	    	this.postlink.click();
	    }
		
	 public void clickTagLink() {
			this.taglink.click();
		}
		
	 public void clickCheckBox()
		{
			this.checkbox.click();
		}
		
		public void clickBulkActions() {
			this.bulkactions.click();
		}
		
	  public void clickDropDown() {
			 
	    	Select dropdown = new Select(dropDown);
	    	dropdown.selectByVisibleText("Delete");
	    	
	    }
	  public void clickApply() {
		  this.Apply.click();
	  }
}
