package Akmaven.genericLib;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenerImplementation implements ITestListener {

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
	  TakesScreenshot ts = (TakesScreenshot)BaseClass.Listenerdriver;
	  File src= ts.getScreenshotAs(OutputType.FILE);
	  File trg=new File("./screenshot/failedts.png");
	  try {
		FileUtils.copyFile(src, trg);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}
	

}
