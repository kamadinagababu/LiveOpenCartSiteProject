package testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepage.Base;
import utils.commonUtils;

public class TC020 extends Base {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver=OpenBrowserAndApplication();
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

     @Test
	public void verifyUIofAccountPage()  {
    	
 		
 		TakesScreenshot ts = (TakesScreenshot)driver;
 		File srcScreenShot = ts.getScreenshotAs(OutputType.FILE);
 		try {
			FileHandler.copy(srcScreenShot, new File(System.getProperty("user.dir")+"\\screenshots\\ActualAccountRegisterUI.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		//compare two images
 		try {
			Assert.assertTrue(commonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\screenshots\\ActualAccountRegisterUI.png", System.getProperty("user.dir")+"\\screenshots\\ExpectedAccountRegisterUI.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
