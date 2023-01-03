package Akmaven.genericLib;

import java.sql.Driver;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	

	public int getRandom() {
		 Random r = new Random();
		 int num=r.nextInt(1000);
		 return num;
	}
	
	public void getSelectbyVisibleText(WebElement dropdown, String visibleText) {
		// TODO Auto-generated method stub
		Select s = new Select(dropdown);
		s.selectByVisibleText(visibleText);
		
	}
	
	public String getAlertPopmsg(WebDriver driver) {
		Alert alt =driver.switchTo().alert();
		String msg=alt.getText();
		System.out.println(msg);
		return msg;
		
	}
	public void alertAccept(WebDriver driver) {
		Alert alt =driver.switchTo().alert();
		alt.accept();
		}
	
}


