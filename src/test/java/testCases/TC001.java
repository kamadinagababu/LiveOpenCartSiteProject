package testCases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC001 {
     @Test
	public void AccountRigister() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("nagababu");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kamadi");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9885065125");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Chaithu@111");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Chaithu@111");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		
		//validatation
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed());
		String expectedHeading="Your Account Has Been Created!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),expectedHeading);
		
		String ActualproperDetailsOne="Congratulations! Your new account has been successfully created!";
		String ActualproperDetailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String ActualproperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String ActualproperDetailsFour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";
		
	 String ExpectedproperDetails=driver.findElement(By.xpath("//div[@id='content']")).getText();
	 Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsOne));
	 Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsTwo));
	 Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsThree));
	 Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsFour));
	 driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
	 Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed());

		
		
		driver.quit();
		
		
	}
	
	

}
