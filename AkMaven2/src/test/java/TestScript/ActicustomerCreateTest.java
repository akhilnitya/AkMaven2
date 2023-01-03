package TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Akmaven.genericLib.BaseClass;
import Akmaven.genericLib.CommonUtility;

@Listeners(Akmaven.genericLib.ListenerImplementation.class)
public class ActicustomerCreateTest extends BaseClass {
	ExtentReports extent = new ExtentReports();
	 ExtentSparkReporter spark = new ExtentSparkReporter("Extendreport.html");
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
	   	ExtentTest test = extent.createTest(" verify thst customer is created ");
	   	test.pass("Customerr Created passed");
	   	test.log(Status.PASS, "customer created");
		 
	}
	 @Test()
	  public void alertpopup()  {
		 ExtentTest test = extent.createTest(" alert is created ");
		   	test.pass("alert passed");
		   	test.log(Status.PASS, "alert created");
	 	  
	 		driver.findElement(By.className("popup_menu_button_setting")).click();
	 		driver.findElement(By.linkText("Types of Work")).click();
	 		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
	 		driver.findElement(By.id("name")).sendKeys("Ak");
	 		driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
	 		Akmaven.genericLib.CommonUtility cu = new Akmaven.genericLib.CommonUtility();
	 		String msg=cu.getAlertPopmsg(driver);
	 		System.out.println(msg);
	 		cu.alertAccept(driver);
	 		


	   }
 
 @BeforeTest
 public void beforeTest() {
	 
	 extent.attachReporter(spark);
	 
 }
 @AfterTest
 public void afterTest() {
	 extent.flush();
 }
 
 
  
}
  


