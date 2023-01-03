package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Akmaven.genericLib.BaseClass;



public class AlertpopTest extends BaseClass {
	ExtentReports extent = new ExtentReports();
	 ExtentSparkReporter spark = new ExtentSparkReporter("ExtendreportAlert.html");
			// TODO Auto-generated method stub
	
		 @Test()
		  public void alertpopup()  {
			 ExtentTest test = extent.createTest(" alert is created ");
			 if(true) {
		 		driver.findElement(By.className("popup_menu_button_setting")).click();
		 		driver.findElement(By.linkText("Types of Work")).click();
		 		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		 		driver.findElement(By.id("name")).sendKeys("Ak");
		 		driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
		 		Akmaven.genericLib.CommonUtility cu = new Akmaven.genericLib.CommonUtility();
		 		String msg=cu.getAlertPopmsg(driver);
		 		System.out.println(msg);
		 		cu.alertAccept(driver);
			   		test.pass("alert passed");
				   	test.log(Status.PASS, "alert pass");
				   	
			 }else {
				 test.fail("alert fail");
				   	test.log(Status.FAIL, "alert fail");
			 }
			   

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


