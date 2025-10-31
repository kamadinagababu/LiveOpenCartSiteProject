package testCases;

import java.time.Duration;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepage.Base;
import utils.commonUtils;

public class TC007 extends Base {
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
	public void verifyRegisterAccountWithInvalidPhNumber() throws InterruptedException {

		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("chaithu");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kamadi");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);

		// account created there was a problem
		// raise the issue and talk to developer

	}

	public String generateRandomEmail() {
		Date date = new Date();
		return date.toString().replaceAll("\\s", "").replaceAll("\\:", "") + "@gmail.com";

	}

}
