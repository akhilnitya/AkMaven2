package Akhil.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Akhil.elementRepository.LoginLocators;

public class BaseClass {
    public WebDriver driver;
    public DataUtility du=new DataUtility();
    static WebDriver Listenerdriver;
	@BeforeClass(alwaysRun=true)
	
	public void launchBrowser() {
    	
    		System.setProperty("webdriver.chrome.driver","D:\\Akhil softwares\\selenium Drivers\\Google ChromeDriver\\chromedriver.exe");
   		 driver = new ChromeDriver();
          Listenerdriver=driver;
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	

	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException {
		driver.get(du.getDatafromProperties("URL"));
		//Pom
		LoginLocators li=new LoginLocators(driver);
		li.loginApp(du.getDatafromProperties("USN"),du.getDatafromProperties("PWD"));
		
		
		
/*		driver.findElement(By.id("username")).sendKeys(du.getDatafromProperties("USN"));
		driver.findElement(By.name("pwd")).sendKeys(du.getDatafromProperties("PWD"));
		
		driver.findElement(By.id("loginButton")).click();*/
	}
	
	@AfterMethod(alwaysRun=true)
	public void logOut() {
		driver.findElement(By.id("logoutLink")).click();
	}
	
	
	@AfterClass(alwaysRun=true)
public void closeBrowser() {
		
		driver.close();
	}
	
	
	
	
	
	
}
