package testCases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC003 {
@Test
	public static void AccountRigsterWithNewsletter() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("nagababu");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kamadi");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("12344554455");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Chaithu@111");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Chaithu@111");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		 
		 driver.findElement(By.xpath("//a[normalize-space()='Subscribe / unsubscribe to newsletter']")).click();
		 
		 Assert.assertTrue(driver.findElement(By.xpath("//h1[normalize-space()='Newsletter Subscription']")).isDisplayed());
		 Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1']")).isSelected());
		 driver.findElement(By.xpath("//input[@value='Continue']")).click();
		 
		 String expectedNewsletteralertMsg="Success: Your newsletter subscription has been successfully updated!";
		 String NewsletterAlertSuccessMsg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		 Assert.assertEquals(NewsletterAlertSuccessMsg, expectedNewsletteralertMsg);
		 
		 driver.quit();
	}




}
