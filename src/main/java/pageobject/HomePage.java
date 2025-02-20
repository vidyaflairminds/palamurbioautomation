package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractcomponent;

public class HomePage extends abstractcomponent{
	
	public WebDriver driver;
	public HomePage (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement search;
	
	@FindBy(xpath="//input[@placeholder='Type keyword, Use commas for multiple keywords']")
	WebElement searchfield;
	
	@FindBy(xpath="//p[text()='Search by Word']")
	WebElement searchradiobutton;
	
	@FindBy(xpath="//p[text()='Search by Phrase']")
	WebElement  searchbyphrase;
	
	@FindBy(xpath="//p[text()='Document Type']")
	WebElement documenttype;
	
	@FindBy(xpath="//input[@value='SOP']")
	WebElement sopfilter;
	
	@FindBy(xpath="//input[@value='TICO']")
	WebElement ticofilter;
	
	@FindBy(xpath="//input[@value='Archives']")
	WebElement archivesfilter;
	
	@FindBy(xpath="//input[@value='Instruments']")
	WebElement instruments;
	
	@FindBy(xpath="//p[text()='Filters']")
	WebElement filters;
	
	@FindBy(xpath="//input[@placeholder='Department Name']")
	WebElement departmentnmae;
	
	@FindBy(xpath="//input[@placeholder='SOP Author']")
	WebElement sopauthor;
	
	@FindBy(xpath="//input[@placeholder='Version (optional)']")
	WebElement version;
	
	@FindBy(xpath="//input[@placeholder='SOP Number']")
	WebElement sopnumber;
	
	@FindBy(xpath="//span[@aria-label='left']//*[name()='svg']")
	WebElement slidebar;
	
	@FindBy(xpath="//span[text()='Home Screen']")
	WebElement homescreen;
	
	@FindBy(xpath="//p[text()='No results generated']")
	WebElement nodata;
	public void search() throws InterruptedException {
		slidebar.click();
		homescreen.click();
		searchfield.sendKeys("sop");
		search.click();
		Thread.sleep(5000);
		
		
		
	}

public String searchclr() throws InterruptedException {
	
	HomePage searchtext=new HomePage(driver);
	searchtext.search();
	searchfield.clear();
	
	searchfield.sendKeys("fm");
	search.click();
	Thread.sleep(5000);
return	nodata.getText();

}
}
