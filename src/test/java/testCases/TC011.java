package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC011 {
	@Test
	public void AccountRegisterWithOnlySpaces()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		

       driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys(" ");
       driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys(" ");
       driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(" ");
       driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys(" ");
       driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(" ");
       driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(" ");
       driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
       driver.findElement(By.xpath("//input[@name='agree']")).click();
       driver.findElement(By.xpath("//input[@value='Continue']")).click();
       
       String FNameWarnigMsg="First Name must be between 1 and 32 characters!";
       String LNameWarningMsg="Last Name must be between 1 and 32 characters!";
       String EmailWarningMsg="E-Mail Address does not appear to be valid!";
       String TelephoneWarningMsg="Telephone must be between 3 and 32 characters!";
       String PwdWarningMsg="Password must be between 4 and 20 characters!";
       
       Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), FNameWarnigMsg);
       Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")).getText(), LNameWarningMsg);
       Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")).getText(), EmailWarningMsg);
       Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")).getText(), TelephoneWarningMsg);
       Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")).getText(), PwdWarningMsg);
		driver.quit();
	}

}
