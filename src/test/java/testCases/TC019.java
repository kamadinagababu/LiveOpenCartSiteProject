package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC019 {
     @Test
	public void verifyBreadcrumbUrlHeadingTitleOfThePage() {
    	 WebDriver driver=new ChromeDriver();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 		driver.get("http://localhost/openCartsite/");
 		driver.manage().window().maximize();
 		
 		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
 		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
 		
 		
 		String expectedHeadingTitle="Register Account";
 		String ActualHeadingTitle=driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
 		Assert.assertEquals(ActualHeadingTitle, expectedHeadingTitle);
 		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Register']")).isDisplayed());
 		
 		String ExpectedUrl="http://localhost/openCartsite/index.php?route=account/register";
 		Assert.assertEquals(driver.getCurrentUrl(), ExpectedUrl);
 		
 		String ExpectedTitle="Register Account";
 		Assert.assertEquals(driver.getTitle(), ExpectedTitle);
 		driver.quit();
	}
}
