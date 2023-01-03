package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Akmaven.genericLib.BaseClass;
import Akmaven.genericLib.CommonUtility;

@Listeners(AutoSel.genericLib.ListenerImplementation.class)
public class ActicustomerCreateTest extends BaseClass {
	
  @Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
	  CommonUtility cu = new CommonUtility();
	    
        int num	=cu.getRandom();
		 driver.findElement(By.id("container_tasks")).click();
		 driver.findElement(By.cssSelector(".title.ellipsis")).click();
		 driver.findElement(By.className("createNewCustomer")).click();
		 driver.findElement(By.className("newNameField")).sendKeys(du.getDatafromExcelsheet("sheet1", 0, 0)+num);
		 driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("Done");
	   	 driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	   	Reporter.log("customer created sucessfully", true);
		 
	}
 
 
 
 
  
}
  


