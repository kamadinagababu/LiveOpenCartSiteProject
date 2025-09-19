package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC009 {
    @Test
	public void verifyPlaceholderInTextFiledInRegisterAccount()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		String ExpectedFistnamePlaceholder="First Name";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("placeholder"), ExpectedFistnamePlaceholder);
		
		String ExpectedLastnamePlaceholder="Last Name";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("placeholder"), ExpectedLastnamePlaceholder);
		
		
		String ExpectedEmailPlaceholder="E-Mail";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("placeholder"), ExpectedEmailPlaceholder);
		
		String ExpectedTelephonePlaceholder="Telephone";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']")).getAttribute("placeholder"), ExpectedTelephonePlaceholder);
		
		
		String ExpectedPasswordPlaceholder="Password";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']")).getAttribute("placeholder"), ExpectedPasswordPlaceholder);
		
		String ExpectedConfirmPasswordPlaceholder="Password Confirm";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']")).getAttribute("placeholder"), ExpectedConfirmPasswordPlaceholder);
		
		driver.quit();
	}
}
