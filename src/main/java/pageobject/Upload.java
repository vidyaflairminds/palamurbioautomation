package pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractcomponent;

public class Upload extends abstractcomponent {
	
	public WebDriver driver;
	public Upload (WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//span[text()='Upload']")
	WebElement uploadbutton;
	
	@FindBy(xpath="//span[text()='PDF']")
	WebElement pdf;
	
	@FindBy(xpath="//span[text()='Excel']")
	WebElement excel;
	
	@FindBy(xpath="//span[text()='Browse']")
	WebElement browse;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement next;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement selectdocumenttype;
	
	@FindBy(xpath="//div[@class='ant-select-item-option-content'][normalize-space()='SOP']")
	WebElement sop;
	@FindBy(name="departmentName")
	WebElement departmentname;
	
	@FindBy(name="sopAuthor")
	WebElement sopauthor;
	
	@FindBy(name="versionOptional")
	WebElement version;
	
	@FindBy(name="sopNumber")
	WebElement sopnumber;
	
	@FindBy(xpath="//button[@type='button']//span[text()='Upload']")
	WebElement upload;
	
	@FindBy(xpath="//span[@aria-label='left']//*[name()='svg']")
	WebElement slidebar;
	
	@FindBy(xpath="//span[text()='Files uploaded successfully']")
	WebElement filesuploaded;
	public String uploadpdf() throws AWTException, InterruptedException {
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		slidebar.click();
		uploadbutton.click();
		pdf.click();
		browse.click();
		
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
				selectdocumenttype.click();
				sop.click();
				departmentname.sendKeys("physiology");
				sopauthor.sendKeys("new");
				version.sendKeys("12");
				sopnumber.sendKeys("1234");
				upload.click();
				
				waitforElementAppear(filesuploaded);
		return		filesuploaded.getText();
				
				
				
				
		
		
		
	}
	
	
	
	
	
	

}
