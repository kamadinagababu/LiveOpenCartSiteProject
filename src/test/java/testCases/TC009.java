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

public class TC009 extends Base {
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
	public void verifyPlaceholderInTextFiledInRegisterAccount() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		String ExpectedFistnamePlaceholder = "First Name";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']")).getAttribute("placeholder"),
				ExpectedFistnamePlaceholder);

		String ExpectedLastnamePlaceholder = "Last Name";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']")).getAttribute("placeholder"),
				ExpectedLastnamePlaceholder);

		String ExpectedEmailPlaceholder = "E-Mail";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']")).getAttribute("placeholder"),
				ExpectedEmailPlaceholder);

		String ExpectedTelephonePlaceholder = "Telephone";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']")).getAttribute("placeholder"),
				ExpectedTelephonePlaceholder);

		String ExpectedPasswordPlaceholder = "Password";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']")).getAttribute("placeholder"),
				ExpectedPasswordPlaceholder);

		String ExpectedConfirmPasswordPlaceholder = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']")).getAttribute("placeholder"),
				ExpectedConfirmPasswordPlaceholder);

	}
}
