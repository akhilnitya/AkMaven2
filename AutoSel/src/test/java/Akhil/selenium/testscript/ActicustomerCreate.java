package Akhil.selenium.testscript;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Akhil.genericLib.BaseClass;
import Akhil.genericLib.CommonUtility;
import Akhil.genericLib.DataUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Listeners(Akhil.genericLib.ListenerImplementation.class)
public class ActicustomerCreate extends BaseClass {
	
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
  


