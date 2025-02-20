package pageobject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

import abstractcomponent.abstractcomponent;

public class Admin extends abstractcomponent {

	public WebDriver driver;
	public Admin(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement admin;
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement usermanagement;
	
	@FindBy(xpath="//input[@placeholder='Search User...']")
	WebElement searchuser;
	
	//@FindBy(xpath="//span[text()='Filter Role']")
	@FindBy(xpath="//input[@type='search']")
	WebElement filterrole;
	
	@FindBy(xpath="//div[text()='All Roles']")
	WebElement allroles;
	
	@FindBy(xpath="//div[text()='Admin']")
	WebElement adminfilter;
	
	@FindBy(xpath="//div[text()='Document Manager']")
	WebElement documentmanager;
	
	@FindBy(xpath="//div[text()='User']")
	WebElement user;
	
	@FindBy(xpath="//span[text()='Update'][1]")
	WebElement update;
	
	@FindBy(xpath="//td[text()='User']//parent::tr//td//button//span[text()='Delete']")
	WebElement delete;
	
	@FindBy(xpath="//button[text()='Add User']")
	WebElement adduser;
	
	@FindBy(id="first_name")
	WebElement firstnamenew;
	
	@FindBy(id="last_name")
	WebElement lastnamenew;
	
	@FindBy(id="user_name")
	WebElement usernamenew;
	
	@FindBy(id="user_email")
	WebElement useremailnew;
	
	@FindBy(id="user_role")
	WebElement userrole;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="confirmPassword")
	WebElement confirmpassword;
	
	@FindBy(id="user_filter")
	WebElement userfilter;
	
	@FindBy(xpath="//span[text()='Add User']")
	WebElement addnewuser;
	
	@FindBy(xpath="//div[text()='Admin']")
	WebElement adminuserrole;
	
	@FindBy(xpath="//div[text()='Document Manager']")
	WebElement documentmanageruserrole;
	
	@FindBy(xpath="//div[text()='User']")
	WebElement normaluser;
	
	@FindBy(xpath="//span[@aria-label='left']//*[name()='svg']")
	WebElement slidebar;
	
	@FindBy(id="password")
	WebElement updatepassword;
	
	@FindBy(id="confirmPassword")
	WebElement updateconfirmpassword;
	
	@FindBy(xpath="//span[text()='Update User']")
	WebElement updateuserbutton;
	
	@FindBy(xpath="//span[text()='OK']")
	WebElement okbutton;
	
	@FindBy(xpath="//span[text()='Export Search History']")
	WebElement exportsearchhistorybutton;
	
	@FindBy(xpath="//div[@class='ant-select-selection-overflow']")
	WebElement chooseuserfilter;
	
	@FindBy(xpath="//span[text()='User Filter must be a valid JSON object.']")
	WebElement updateerrormsg;
	
	@FindBy(xpath="//span[text()='User updated successfully!']")
	WebElement updateusersucssesfull;
	
	@FindBy(xpath="//span[text()='User added successfully!']")
	WebElement useraddedsucssesfully;
	
	@FindBy(xpath="//span[text()='User already exists']")
	WebElement useraddedalready;
	
	@FindBy(xpath="//span[text()='User deleted successfully.']")
	WebElement userdeleted;
	
	@FindBy(xpath="//span[text()='History']")
	WebElement historybuton;
	
	@FindBy(xpath="//div[@class='ant-drawer-title']//span[text()='History']")
	WebElement history;
	
	
	public  String createnewuser() throws IOException, InterruptedException {
		slidebar.click();
		admin.click();
		usermanagement.click();
		adduser.click();
		Properties prop = new Properties();
		FileInputStream fsi = new FileInputStream(
		(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties"));
		prop.load(fsi);
		String firstname=prop.getProperty("adduserFirstname");
		String lastname=prop.getProperty("adduserLastname");
		String username=randomusernamestring();
		String useremail=randomstring();
		String password1=prop.getProperty("adduserpassword");
		String confirmpassword1=prop.getProperty("adduserconfirmpassword");
		String userfilter1=prop.getProperty("userfilter");
		
		firstnamenew.sendKeys(firstname);
		lastnamenew.sendKeys(lastname);
		usernamenew.sendKeys(username);
		useremailnew.sendKeys(useremail);
		userrole.click();
		adminuserrole.click();
		password.sendKeys(password1);
		confirmpassword.sendKeys(confirmpassword1);
		userfilter.sendKeys(userfilter1);
			
		addnewuser.click();
		Thread.sleep(2000);
		return useraddedsucssesfully.getText();
		
	
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
	
	 public String createusersamemailid() throws IOException, InterruptedException {
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 slidebar.click();
			admin.click();
			usermanagement.click();
			adduser.click();
			Properties prop = new Properties();
			FileInputStream fsi = new FileInputStream(
			(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\globaldata.properties"));
			prop.load(fsi);
			String firstname=prop.getProperty("adduserFirstname");
			String lastname=prop.getProperty("adduserLastname");
			String username=prop.getProperty("Username");
			String useremail=prop.getProperty("Useremail");
			String password1=prop.getProperty("adduserpassword");
			String confirmpassword1=prop.getProperty("adduserconfirmpassword");
			String userfilter1=prop.getProperty("userfilter");
			
			firstnamenew.sendKeys(firstname);
			
		lastnamenew.sendKeys(lastname);
			usernamenew.sendKeys(username);
			useremailnew.sendKeys(useremail);
			userrole.click();
			adminuserrole.click();
		
			password.sendKeys(password1);
			confirmpassword.sendKeys(confirmpassword1);
		userfilter.sendKeys(userfilter1);
				
			adduser.click();
			Thread.sleep(2000);
			return useraddedalready.getText();
		 
	 }
	 
	 public  String updateuser() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 slidebar.click();
			admin.click();
			usermanagement.click();
			update.click();
			updatepassword.sendKeys("143test@Pune");
			updateconfirmpassword.sendKeys("143test@Pune");
			updateuserbutton.click();
			Thread.sleep(2000);
	return		updateusersucssesfull.getText();
			
			
	 }
	 
	 public String deleteuser() throws InterruptedException {
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 slidebar.click();
			admin.click();
			usermanagement.click();
			delete.click();
			okbutton.click();
			Thread.sleep(200);
	return	userdeleted.getText();
			
	 }
	 
	 public String searchuserfilter() throws InterruptedException {
		 slidebar.click();
			admin.click();
			usermanagement.click();
			searchuser.sendKeys("new");
			
			Thread.sleep(5000);
			//find all rows in table
		//	List<WebElement>dynamicrow=driver.findElements(By.xpath("//th[text()='User Email']/ancestor::table//tbody//tr//td[1]"));
			List<WebElement>rowno=driver.findElements(By.xpath("//th[text()='User Email']/ancestor::table//tbody//tr"));
			//get total no of rows
		String search="new";
		
			int rowcount=rowno.size();
			List<WebElement>colno=driver.findElements(By.xpath("//th"));
			int colnumber=colno.size();
			
			 for(int r=1;r<=rowcount;r++) {
				 
				 for(int c=1;c<=colnumber;c++) {
				 
				 //dynamic x path for cell
				
				 String dynamicxpath=String.format("//th[text()='User Email']/ancestor::table//tbody//tr["+r+"]//td["+c+"]",r,c );
				 WebElement cellelement=driver.findElement(By.xpath(dynamicxpath));
				 String celltext=cellelement.getText();
				 //validate specific word "new" find
				 
				 if(celltext.contains(search)) {
					 
					 
					 System.out.println("Found the word '" + search + "' in row " + r + ", column " + c + ": " + celltext);
				 }}}
			return search;
              
			
		 
	 }
	 
	 public String filterroleclick() throws InterruptedException {
		 slidebar.click();
			admin.click();
			usermanagement.click();
			filterrole.click();
			adminfilter.click();
			String search="Admin";
			List<WebElement> row=driver.findElements(By.xpath("//tbody//tr"));
			int rowno=row.size();
			int colno=3;
			List<WebElement> role=driver.findElements(By.xpath("//tbody//tr//td[3]"));
			for(int r=1;r<=rowno;r++) {
				
				for(int c=1;c<=colno;c++) {
					
					String dynamicxpath=String.format("//tbody//tr["+r+"]//td["+c+"]", r,c);
					WebElement cellelement=driver.findElement(By.xpath(dynamicxpath));
					String celltext=cellelement.getText();
					if(celltext.contains(search)) {
						 
						 
						 System.out.println("Found the word '" + search + "' in row " + r + ", column " + c + ": " + celltext);
					 }
				}
			}
			
			return search;
	 }
	 
	 public void exportsearchhistory() throws InterruptedException {
		 slidebar.click();
			admin.click();
			exportsearchhistorybutton.click();
			chooseuserfilter.click();
		//	Thread.sleep(10000);
			
		 
	 }
			public WebElement history() throws InterruptedException {
				
				slidebar.click();
				historybuton.click();
				Thread.sleep(2000);
				return history;
				
				
			}
			
			
			
		 
	 
		 
	 
}
