package Akmaven.genericLib;

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

import elementRepo.LoginLocators;





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
	
   // @Parameters({"username","password"})
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException {
		driver.get(du.getDatafromProperties("URL"));
		LoginLocators l1= new LoginLocators(driver);
		l1.loginApp(du.getDatafromProperties("username"),du.getDatafromProperties("password"));
		
	/*driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.name("pwd")).sendKeys(password);
		
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
