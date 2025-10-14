package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC012 {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(dataProvider = "passwordSupply")
	public void VerifyRegisterAccountAndCheckingPasswordComplexityStandars(String passwordText) {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("arun");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("mootiri");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(passwordText);
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys(passwordText);
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ExpectedWarningPasswordMsg = "password enter is not matching the complexity standards";
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]"))
						.getText(),
				ExpectedWarningPasswordMsg);
		Assert.assertFalse(driver.findElement(By.xpath("//a[normalize-space()='Success']")).isDisplayed());

	}

	@DataProvider(name = "passwordSupply")
	public Object[][] supplyPassword() {
		Object[][] data = { { "1234" }, { "abcdefghi" }, { "abcdf123" }, { "ABCDEF456" }, { "ABCDEF#" } };
		return data;
	}
}
