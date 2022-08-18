package Akhil.selenium.testscript;

import org.testng.annotations.Test;

import Akhil.genericLib.BaseClass;
import Akhil.genericLib.CommonUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DropdownHandling extends BaseClass {
	
	
	  @Test(groups= {"system"})
	  public void handleDropdown() {
		    driver.findElement(By.className("popup_menu_button_settings")).click();
			driver.findElement(By.xpath("//div[contains(text(),'Manage system settings')]/..")).click();
			WebElement dropdown=driver.findElement(By.id("secondHierarchyLevelCodeSelect"));
			CommonUtility cu = new CommonUtility();
			cu.getSelectbyVisibleText(dropdown,"Product");
			String msg=driver.findElement(By.id("FormModifiedTextCell")).getText();
			System.out.println(msg);
	  }
	  
	 

}
