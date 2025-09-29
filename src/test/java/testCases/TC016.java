package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC016 {
	@Test
	public void verifyVisibilityTogglineOfPasswordFieldOnRegisterAccount() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("honey");
		driver.findElement(By.id("input-lastname")).sendKeys("pesingi");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("6584845154");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		driver.findElement(By.id("input-confirm")).sendKeys("123456");
		
		 WebElement pwd = driver.findElement(By.id("input-password"));
		 Assert.assertEquals(pwd.getAttribute("type"), "password");
		 driver.quit();
	}

}
