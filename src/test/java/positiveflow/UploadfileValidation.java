package positiveflow;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.DocumentManagement;
import pageobject.Upload;
import testcomponent.BaseTest;

public class UploadfileValidation extends BaseTest{
	
	//verify that admin user is able to upload the pdf file
	@Test
	public void pdfupload() throws IOException, AWTException, InterruptedException {
		String expectedtext="Files uploaded successfully";
		page.enterloginvaliddata();
		Upload element=new Upload(driver);
		String actualtext=element.uploadpdf();
		Assert.assertEquals(expectedtext, actualtext);
		
		
	}
	
	//verify that admin user is able to view uploaded pdf through view button----------------done
	@Test
	public void pdfview() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		DocumentManagement ele=new DocumentManagement(driver);
		ele.viewpdf();
		
	}
	
	//verify that user is able to update file through update new pdf from document management
	@Test
	public void updatepdf() throws IOException, AWTException, InterruptedException {
	//	String expectedtext="Files uploaded successfully";
		page.enterloginvaliddata();
		DocumentManagement ele=new DocumentManagement(driver);
        	ele.updatepdf();
      //  Assert.assertEquals(expectedtext, actualtext);
	}
	
	//verify that user is able to delete uploaded file from document management
	@Test
	public void deleteuploadedpdf() throws IOException, InterruptedException {
		page.enterloginvaliddata();
		DocumentManagement ele=new DocumentManagement(driver);
		ele.deletepdf();
		
		
	}
		
	//verify that docmanager user is able to upload pdf file.
	@Test
	public void docmanagerpdfupload() throws IOException, AWTException, InterruptedException {
	//	String expectedtext="Files uploaded successfully";
		page.docmanagerlogin();
		Upload element=new Upload(driver);
		element.uploadpdf();
	//	Assert.assertEquals(expectedtext, actualtext);
	}

}
