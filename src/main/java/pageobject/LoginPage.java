package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractcomponent.abstractcomponent;

public class LoginPage extends abstractcomponent {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="loginForm_email")
	WebElement email;
	
	@FindBy(id="loginForm_password")
	WebElement password;
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//a[normalize-space()='Register here']")
	WebElement register;
	
	@FindBy(xpath="//img[@class='_logo_img_15z1v_31']")
	WebElement flairmindslogo;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchbutton;
	
	@FindBy(xpath="//span[text()='Invalid user email or password']")
	WebElement invaliduser;
	
	
	public void enterloginvaliddata() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fsi = new FileInputStream(
		(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties"));
		prop.load(fsi);
		String email1 = prop.getProperty("email");
		String password1 = prop.getProperty("password");
		email.sendKeys(email1);
		password.sendKeys(password1);
		login.click();
		
		
	}
	
	public void  goTo() throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream fsi = new FileInputStream(
		(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties"));
		prop.load(fsi);
		String link = prop.getProperty("url");
		driver.get(link);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	public String enterinvaliddata() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fsi = new FileInputStream(
		(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties"));
		prop.load(fsi);
		String email1 = prop.getProperty("newemail");
		String password1 = prop.getProperty("wrongpassword");
		email.sendKeys(email1);
		password.sendKeys(password1);
		login.click();
		return invaliduser.getText();
		
		
	}
	
	public   Register navigateToRegister() {
		Actions act = new Actions(driver);
		act.click(register).perform();
		Register sign = new Register(driver);
		return sign;
	}
	
public WebElement Searchbutton() {
		return searchbutton;
		
	}

	public void docmanagerlogin() throws IOException {
		Properties prop = new Properties();
		FileInputStream fsi = new FileInputStream(
		(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties"));
		prop.load(fsi);
		String email1 = prop.getProperty("docmanageremail");
		String password1 = prop.getProperty("docmanagerpassword");
		email.sendKeys(email1);
		password.sendKeys(password1);
		login.click();
		
	}
	
}


	

