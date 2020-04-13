package fbtestngclass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class FBTutoringPractice {
	public static WebDriver driver;
	
  @Test (priority = 1)
  public void sign_in() {
	  
	  driver.findElement(By.id("email")).sendKeys("m1555@umbc.edu");
	  
	  driver.findElement(By.id("pass")).sendKeys("Abc1234");
	  
	  driver.findElement(By.id("u_0_b")).click();
	  

  }
  
  @Test(priority = 2)
  public void sign_in_second() {
	  
	  driver.findElement(By.id("email")).sendKeys("m1555@umbc.edu");
	  
	  driver.findElement(By.id("pass00")).sendKeys("Abc1234");
	  
	  driver.findElement(By.id("u_0_b")).click();
	  

  }
  
  @BeforeClass
  @Parameters ({"url", "browser"})
  public void beforeClass(String website, String browser_link) {
	  
	  if (browser_link.equalsIgnoreCase("chrome")) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anis\\eclipse-workspace\\FBpractice\\Driver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(website);
	  driver.manage().window().maximize();
	  
	  } else if (browser_link.equalsIgnoreCase("firefox")) {
		  
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Anis\\eclipse-workspace\\EbayFunctional\\Driver\\geckodriver.exe");
		  driver = new FirefoxDriver();
		  driver.get(website);
		  driver.manage().window().maximize();
		  
	  } else {
		  
		  System.out.println("You may need to check your browser setup!!!!");
	  }
	  
  }

  @AfterClass
  public void afterClass() throws InterruptedException, IOException {
	  
	  Thread.sleep(6000);
	  

	  //driver.close();
	  driver.quit();
  }
  
  public void fb_screenshots (String destination) throws IOException {
	  
	  File fb_shots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(fb_shots, new File(destination +fb_timestamp () + "fbscreenshots.png"));

  }
  public String fb_timestamp () {
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	  
  }
  
  public void onTestSuccess() {
	  
  }
  
  public void onTestFailure() {
	  
  }
  
  

}
