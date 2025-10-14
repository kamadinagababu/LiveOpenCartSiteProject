package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC008 {

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

	@Test
	public void verifyAccountRegisterUsingKeyboardKeys() {

		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		Actions actions = new Actions(driver);

		for (int i = 0; i <= 22; i++) {
			actions.sendKeys(Keys.TAB).perform();
		}
		actions.sendKeys("arun").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("mohanalal").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(commonUtils.generateRandomEmail()).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("123456789").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("12345").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE)
				.pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER)
				.build().perform();

		Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Success']")).isDisplayed());

	}

}
