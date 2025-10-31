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

public class TC014 extends Base {

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
	public void VerifyPrivacyPolicyFieldOnRegisterAccountPage() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		Assert.assertFalse(driver.findElement(By.xpath("//input[@name='agree']")).isSelected());

	}

}
