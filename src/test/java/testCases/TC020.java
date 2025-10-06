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
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC020 {
     @Test
	public void verifyUIofAccountPage()  {
    	 WebDriver driver=new ChromeDriver();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 		driver.get("http://localhost/openCartsite/");
 		driver.manage().window().maximize();
 		
 		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
 		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
 		
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
 		driver.quit();
	}
}
