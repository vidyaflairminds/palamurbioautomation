package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractcomponent;

public class ExportSearchHistory extends abstractcomponent{
	
	
	public WebDriver driver;
	public ExportSearchHistory (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//span[text()='Choose users to filter.....']")
	WebElement userfilter;
	
	@FindBy(xpath="//button[@type='button']//span[text()='Apply Filter']")
	WebElement applyfilter;
	
	@FindBy(xpath="//span[text()='Export with Filters']")
	WebElement exportfilter;
	
	@FindBy(xpath="//span[text()='Export All']")
	WebElement exportall;
	
	@FindBy(xpath="//span[normalize-space()='Palamur Admin']")
	WebElement chooseuserfilterdropdown;
	
	
		public void exportsearchhistory() throws InterruptedException {
			Admin element=new Admin(driver);
	element. slidebar.click();
	element.admin.click();
	element.exportsearchhistorybutton.click();
		element.chooseuserfilter.click();
		chooseuserfilterdropdown.click();
		//Thread.sleep(10000);
	//	chooseuserfilterdropdown.click();
		applyfilter.click();
		Thread.sleep(10000);
			
		
		}
		
		public void exportwithfilter() throws InterruptedException {
			
			Admin element=new Admin(driver);
			element. slidebar.click();
			element.admin.click();
			element.exportsearchhistorybutton.click();
			exportfilter.click();
			
			exportall.click();
			Thread.sleep(2000);
		
			
		}

}
