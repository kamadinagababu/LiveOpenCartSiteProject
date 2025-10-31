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

public class TC002 extends Base {

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
	public void VerifyRegisterAccountWithoutFillFileds() {

		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String expectedFirstnameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastnameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPaswwordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(driver
				.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]"))
				.getText(), expectedFirstnameWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]"))
						.getText(),
				expectedLastnameWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
						.getText(),
				expectedEmailWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
						.getText(),
				expectedTelephoneWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
						.getText(),
				expectedPaswwordWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				expectedPrivacyWarning);

	}

}
