package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC005 {
	@Test
	public void verifyAccountRegisterWithExitEmail()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/openCartsite/");
		
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
     driver.quit();
		
	}

}
