package positiveflow;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.Admin;
import pageobject.DocumentManagement;
import pageobject.ExportSearchHistory;
import pageobject.HomePage;
import pageobject.Profile;
import testcomponent.BaseTest;

public class AdminUserValidation extends BaseTest {
	
	//Verify that login with admin user we are able to create new user.---------done
	@Test
	public void newusercreation() throws IOException, InterruptedException {
		String expectedtext="User added successfully!";
		page.enterloginvaliddata();
		Admin newuser=new Admin(driver);
	String actualtext=	newuser.createnewuser();
	Assert.assertEquals(expectedtext, actualtext);
		
		
	}
  //verify that login with admin user we are not able to create new user with same mail id.
	@Test
	public void newusersamemailid() throws IOException, InterruptedException {
		String expectedtext="User already exists";
		page.enterloginvaliddata();
		Admin newuser=new Admin(driver);
  //  String actualtext=newuser.createusersamemailid();
  //  Assert.assertEquals(expectedtext, actualtext);
		
	}
	
	//Verify that admin user is able to update the allready created user in userlist--------------done
	@Test
	public void updateuser() throws IOException, InterruptedException {
		String expectedtext="User updated successfully!";
		page.enterloginvaliddata();
		Admin newuser=new Admin(driver);
String actualtext=		newuser.updateuser();
Assert.assertEquals(expectedtext, actualtext);
		
	}
	
	//verify that admin user is able to delete the allready created user---------------done
	@Test
	public void deleteuser() throws IOException, InterruptedException {
		String expectedtext="User deleted successfully.";
		page.enterloginvaliddata();
		Admin newuser=new Admin(driver);
	String actualtext=	newuser.deleteuser();
	Assert.assertEquals(expectedtext, actualtext);
	}
		
	//verify that ADMIN user is able to search userrole using searchfilter------DONE
	@Test
	public void searchuserfilter() throws IOException, InterruptedException {
		String search="new";
		page.enterloginvaliddata();
		Admin newuser=new Admin(driver);
String celltext=    	newuser.searchuserfilter();
     	Assert.assertTrue(celltext.contains(search),     "The string does not contain the expected word: " + search);
		
		
	}
	
	//verify that admin user is able to filter userrole using filterrole from dropdown--------DONE
	@Test
		public void userrolefilter() throws IOException, InterruptedException {
		String search="Admin";
			page.enterloginvaliddata();
			Admin newuser=new Admin(driver);
String celltext=newuser.filterroleclick();
  Assert.assertTrue(celltext.contains(search), "The string does not contain the expected word:"+search);
			
			
			
	}
		
		
	//verify that admin user is able to filter the user using export search history filter.-------DONE
	@Test
	public void exportsearchhistoryfilter() throws IOException, InterruptedException {
		page.enterloginvaliddata();
	
		ExportSearchHistory newuser=new ExportSearchHistory(driver);
		newuser.exportsearchhistory();
		
		
	}
	
	//verify that admin user is able to do search document using document management by filter docname.
	@Test
	public void documentmanagement() throws IOException, InterruptedException {
		page.enterloginvaliddata();
		DocumentManagement docsearch=new DocumentManagement(driver);
		docsearch.searchbydocumentname();
	}

	//Verify that admin user is able to do search by document using filter doctype---------DONE
	@Test
	public void doctype() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		DocumentManagement docsearch=new DocumentManagement(driver);
		docsearch.searchbydocumenttype();
		
	}
	//verify that user is able to search uploaded document using enter text in search field.-----------done
	@Test
	public void searchtext() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		HomePage searchele=new HomePage(driver);
		searchele.search();
	}
	//verify that user is able to click on profile and view the profile------------done
	@Test
	public void profile() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		Profile profileele=new Profile(driver);
WebElement resetbutton=		profileele.profileview();

Assert.assertTrue(resetbutton.isDisplayed(), "reset button is not present");
	}
	
	//verify that admin user is able to signout sucssesfully----------------done
	@Test
	public void signout() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		Profile profileele=new Profile(driver);
		WebElement login=	profileele.signout();
		Assert.assertTrue(login.isDisplayed(), "login button is not present");
		
		
	}
	
	//verify that history button functionality
	@Test
	public void history() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		Admin user=new Admin(driver);
WebElement histt=user.history();
		Assert.assertTrue(histt.isDisplayed(),"history button is not present");
	
	}
	
	//verify that in search filed enter search text and again enter invalid text for search------done
	@Test
	public void searchnewword() throws IOException, InterruptedException {
		String expectedtext="No results generated";
		page.enterloginvaliddata();
		HomePage searchele=new HomePage(driver);
        String actualtext=searchele.searchclr();
        Assert.assertEquals(expectedtext, actualtext);
	}
	
	//verify that reset password functionality for admin user----------------done
		@Test
		public void resetfunctinality() throws IOException, InterruptedException {
		String expectedtext="Password changed successfully!";	
			page.enterloginvaliddata();
			Profile reset=new Profile(driver);
        String actualtext= reset.resetpassword();
	Assert.assertEquals(expectedtext, actualtext);
		}
}
