package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepage.Base;

public class TC017 extends Base {

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
	public void verifyWorkingOfEveryLinkOnRegisterAccountPage() throws InterruptedException {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//a/i[@class='fa fa-phone']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Contact Us']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a/i[@class='fa fa-heart']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a/i[@class='fa fa-shopping-cart']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Shopping Cart']")).isDisplayed());

		driver.navigate().back();
		driver.findElement(By.linkText("Checkout")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Shopping Cart']")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//div[@id='logo']//a[text()='Qafox.com']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://tutorialsninja.com/demo/index.php?route=common/home");

		driver.navigate().back();

		driver.findElement(By.xpath("//button//i[@class='fa fa-search']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//i[@class='fa fa-home']")).isDisplayed());

		driver.navigate().back();
		WebElement home = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", home);

		Assert.assertTrue(driver.findElement(By.linkText("Qafox.com")).isDisplayed());
		driver.navigate().back();

		driver.findElement(By.linkText("login page")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed());

		driver.navigate().back();

		driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Forgotten Password']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//li//a[text()='Account']")).isDisplayed());
		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='agree']//b[text()='Privacy Policy']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class='close']")).isDisplayed());
		driver.findElement(By.xpath("//button[@class='close']")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[normalize-space()='Register']"))
				.isDisplayed());

		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Login']")).isDisplayed());

		driver.navigate().back();
		driver.findElement(By.xpath("//a[@class='list-group-item'][text()='Register']")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Register']")).isDisplayed());

	}
}
