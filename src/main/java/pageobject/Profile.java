package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abstractcomponent.abstractcomponent;

public class Profile extends abstractcomponent {
	
	public WebDriver driver;
	public Profile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//span[@aria-label='left']//*[name()='svg']")
	WebElement slidebar;
	
	@FindBy(xpath="//b[text()='Palamur']")
	WebElement palamur;
	
	@FindBy(xpath="//span[text()='Profile']")
	WebElement profile;
	
	@FindBy(xpath="//span[text()='Sign Out']")
	WebElement signout;
	
	@FindBy(xpath="//span[text()='Home Screen']")
	WebElement  homescreen;
	
	@FindBy(xpath="//button[text()='Reset Password']")
	WebElement resetpasswordbuton;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement login;
	
	@FindBy(id="currentPassword")
	WebElement currentpasswordfield;
	
	@FindBy(id="newPassword")
	WebElement newpassword;
	
	@FindBy(id="confirmPassword")
	WebElement confirmpassword;
	
	@FindBy(xpath="//button[text()='Reset Password']")
	WebElement restbutton;
	
	@FindBy(xpath="//span[text()='Password changed successfully!']")
	WebElement resetpasswordmsg;
	
	@FindBy(xpath="//button[text()='Save Password']")
	WebElement savepassword;
	
	public WebElement profileview() throws InterruptedException {
		
		slidebar.click();
		palamur.click();
		
		profile.click();
		Thread.sleep(2000);
		return resetpasswordbuton;
	}
	
	public WebElement signout() throws InterruptedException {
		
		slidebar.click();
		palamur.click();
		signout.click();
		Thread.sleep(2000);
		return login;
	}
	
	public String  resetpassword() throws InterruptedException {
		
		slidebar.click();
		palamur.click();
		profile.click();
		resetpasswordbuton.click();
		currentpasswordfield.sendKeys("admin@123");
		newpassword.sendKeys("admin@123");
		confirmpassword.sendKeys("admin@123");
		savepassword.click();
		Thread.sleep(2000);
		return resetpasswordmsg.getText();
		
		
		
		
		
		
		
	}

}
