package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC015 {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verifyRegisterAccountWithoutPrivacyPolicySelection() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.id("input-firstname")).sendKeys("honey");
		driver.findElement(By.id("input-lastname")).sendKeys("pesingi");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("6584845154");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		String ExpectedWarningMsg = "Warning: You must agree to the Privacy Policy!";
		String ActualWarningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))
				.getText();
		Assert.assertEquals(ActualWarningMsg, ExpectedWarningMsg);

	}

}
