package pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import abstractcomponent.abstractcomponent;

public class Register extends abstractcomponent {
	public WebDriver driver;
	public Register(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Register here']")
	WebElement register;
	
	@FindBy(id="registerForm_email")
	WebElement registerformemail;
	
	@FindBy(id="registerForm_username")
	WebElement registerformusername;
	
	@FindBy(id="registerForm_first_name")
	WebElement registerformfirstnmae;
	
	@FindBy(id="registerForm_last_name")
	WebElement registerformlastname;
	
	@FindBy(id="registerForm_password")
	WebElement registerformpassword;
	
	@FindBy(xpath="//span[text()='Register']")
	WebElement registerbutton;
	
		
	public void registernewuser() throws IOException, InterruptedException {
		
		
		LoginPage registerclick=new LoginPage(driver);
		registerclick.goTo();
		register.click();
		String registeremail=randomstring();
		String registerusername=randomusernamestring();
		registerformemail.sendKeys(registeremail);
		registerformusername.sendKeys(registerusername);
		
		
		registerformfirstnmae.sendKeys("abc");
		registerformlastname.sendKeys("def");
		registerformpassword.sendKeys("test143@Pune");
		registerbutton.click();
		
	}
	
	public String randomstring() {
		Faker random = new Faker();
		String firstname = random.name().firstName();
		String lastname = random.name().lastName();
		String email = firstname.toLowerCase() + "" + lastname.toLowerCase() + "@gmail.com";
		
		return email;
		
	}
	
	public String randomusernamestring() {
		Faker random = new Faker();
		String firstname = random.name().firstName();
		String lastname = random.name().lastName();
		String username = firstname.toLowerCase() + "" + lastname.toLowerCase() ;
		return username;
	}
	
	
	
		
		
		
		
		
		
	
	
	
	


}
