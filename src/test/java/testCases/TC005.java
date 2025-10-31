package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepage.Base;

public class TC005 extends Base {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
	driver=OpenBrowserAndApplication();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test
	public void verifyAccountRegisterWithExitEmail()
	{
		
		driver.findElement(By.xpath("//ul[@class='list-inline']//li[@class='dropdown']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("naga");
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("babu");
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("chaitanyak0324@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9885065125");
       driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
       driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
       driver.findElement(By.xpath("//input[@value='0']")).click();
     driver.findElement(By.xpath("//input[@name='agree']")).click();
     driver.findElement(By.xpath("//input[@value='Continue']")).click();
     
     String ExpectedWarnigMsg="Warning: E-Mail Address is already registered!";
     
     Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), ExpectedWarnigMsg);
    
		
	}

}
