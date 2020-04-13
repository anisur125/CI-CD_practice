package fbtestngclass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Itestlistener extends FBTutoringPractice implements ITestListener {
	
	public static WebDriver driver;

	@Override
	public void onTestSuccess (ITestResult result) {
		
		try {
			fb_screenshots("C:\\Users\\Anis\\eclipse-workspace\\FBpractice\\FBScreenshots\\Passed\\");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure (ITestResult result) {
		
		try {
			fb_screenshots("C:\\Users\\Anis\\eclipse-workspace\\FBpractice\\FBScreenshots\\Failed\\");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
