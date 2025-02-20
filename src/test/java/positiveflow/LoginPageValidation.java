package positiveflow;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.profiler.model.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageobject.LoginPage;
import pageobject.Register;
import testcomponent.BaseTest;

public class LoginPageValidation extends BaseTest{
	
	
	
	//Verify that user is able to login with valid username and valid password.------done
	@Test
	public void logInValidusername() throws IOException {
		
		page.enterloginvaliddata();
		LoginPage element=new LoginPage(driver);
WebElement	searchbutton=	element.Searchbutton();
	
Assert.assertTrue(searchbutton.isDisplayed(),"search button is not present");
		
				
	}
	
	//Verify that user is able to login with wrong password.--------done
	@Test
	public void loginInValidusernmae() throws IOException {
		String expectedtext="Invalid user email or password";
        String actualtext=page.enterinvaliddata();
        Assert.assertEquals(actualtext,expectedtext );
		
	}
	
	
	//verify that new user is created using register form on loginpage.------done
	@Test
	public void newUserForRegistration() throws IOException, InterruptedException {
		
		Register element=new Register(driver);
		element.registernewuser();
		
	}
		
	//verify that docmanager is able to login with valid email and password----done
	@Test
	public void docmanagerlogin() throws IOException {
		
		page.docmanagerlogin();
		LoginPage element=new LoginPage(driver);
		WebElement	searchbutton=	element.Searchbutton();
			
		Assert.assertTrue(searchbutton.isDisplayed(),"search button is not present");
				
	}
		
		
		
		
		
		
		
		
	}


