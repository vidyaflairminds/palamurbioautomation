package pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractcomponent;

public class DocumentManagement extends abstractcomponent{
	
	public WebDriver driver;
	public DocumentManagement(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@placeholder='Search by document name']")
	WebElement documentnamesearchfilter;
	
	@FindBy(xpath="//span[text()='Document Management']")
	WebElement documentmanagement;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchdocument;
	
	@FindBy(xpath="//tbody/tr[1]/td[4]/button[1]")
	WebElement viewbutton;
	
	@FindBy(xpath="//button[text()='Update'][1]")
	WebElement updatebutton;
	
	@FindBy(xpath="//button[text()='Delete'][1]")
	WebElement deletebutton;
	
	@FindBy(xpath="//span[text()='Palamur Admin']")
	WebElement palamuruser;
	
	@FindBy(xpath="//span[@aria-label='left']//*[name()='svg']")
	WebElement slidebar;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement admin;
	
	@FindBy(xpath="//div[text()='SOP']")
	WebElement sopdropdown;
	
	@FindBy(xpath="//span[text()='Files uploaded successfully']")
	WebElement updatemessage;
	
	@FindBy(xpath="//span[text()='Document deleted successfully.']")
	WebElement deletemessage;
	
	@FindBy(xpath="//span[text()='Browse']")
	WebElement browsebutton;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//span[text()='Update']")
	WebElement updatenewfilebutton;
	
	@FindBy(xpath="//span[text()='OK']")
	WebElement ok;
	
	public void searchbydocumentname() throws InterruptedException {
		
		slidebar.click();
		admin.click();
		documentmanagement.click();
		documentnamesearchfilter.sendKeys("fm");
		Thread.sleep(200);
		
	}
	
	public void searchbydocumenttype() throws InterruptedException {
		
		slidebar.click();
		admin.click();
		documentmanagement.click();
		searchdocument.click();
		Thread.sleep(200);
		sopdropdown.click();
		
	}
	
	public void viewpdf() throws InterruptedException {
		
		slidebar.click();
		admin.click();
		documentmanagement.click();
		viewbutton.click();
		Thread.sleep(2000);
		
	}
	
	public String updatepdf() throws AWTException, InterruptedException {
		slidebar.click();
		admin.click();
		documentmanagement.click();
		updatebutton.click();
		browsebutton.click();
		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss=new StringSelection("C:\\Users\\vidya\\Downloads\\SOP PBS TIC 001 04 03 CONTROL PROCEDURES FOR TEST AND REFERENCE ITEMS");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//ctr v action
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);

				rb.keyRelease(KeyEvent.VK_CONTROL);
				rb.keyRelease(KeyEvent.VK_V);

				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				next.click();
				updatenewfilebutton.click();
			//	waitforElementAppear(updatemessage);
			return updatemessage.getText();
				
	}
	
	public void deletepdf() throws InterruptedException {
		
		slidebar.click();
		admin.click();
		documentmanagement.click();
		deletebutton.click();
		Thread.sleep(200);
		ok.click();
		Thread.sleep(200);
		
		
	}
		
		
		
	

}
