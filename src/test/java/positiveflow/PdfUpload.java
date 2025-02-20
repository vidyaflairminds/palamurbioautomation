package positiveflow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PdfUpload {

	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriver driver=new ChromeDriver();
		driver.get("http://dev-docsearch.centralindia.azurecontainer.io/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("loginForm_email")).sendKeys("admin@palamur.com");
		driver.findElement(By.id("loginForm_password")).sendKeys("admin@123");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
		
		//verify that user is able to upload the 
        Thread.sleep(2000);
	driver.findElement(By.xpath("//span[@aria-label='left']//*[name()='svg']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='Upload']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='PDF']")).click();
	driver.findElement(By.xpath("//span[text()='Browse']")).click();

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
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			driver.findElement(By.xpath("//input[@type='search']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//div[@class='ant-select-item-option-content'][normalize-space()='SOP']")).click();
			driver.findElement(By.name("departmentName")).sendKeys("physiology");
			driver.findElement(By.name("sopAuthor")).sendKeys("new");
			driver.findElement(By.name("versionOptional")).sendKeys("12");
			driver.findElement(By.name("sopNumber")).sendKeys("1234");
			driver.findElement(By.xpath("//button[@type='button']//span[text()='Upload']")).click();
			

}
}