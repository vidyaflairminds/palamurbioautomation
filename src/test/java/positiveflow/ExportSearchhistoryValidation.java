package positiveflow;

import java.io.IOException;

import org.testng.annotations.Test;

import pageobject.ExportSearchHistory;
import testcomponent.BaseTest;

public class ExportSearchhistoryValidation extends BaseTest{
	
	//verify that user is able to apply filter on choose user filter for exportsearch history---done
	@Test
	
	public void ExportSearch() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		ExportSearchHistory searchele=new ExportSearchHistory(driver);
		searchele.exportsearchhistory();
	}
	
	//verify that user is able to filter with apply filter and export with all filter button-----done
	@Test
	public void Exportfilter() throws IOException, InterruptedException {
		
		page.enterloginvaliddata();
		ExportSearchHistory searchele=new ExportSearchHistory(driver);
		searchele.exportwithfilter();
	}

}

