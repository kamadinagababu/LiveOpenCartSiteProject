package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC018 {
	@Test
	public void verifyRegisterAccountWithoutEnterTheConfirmPassword() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("honey");
		driver.findElement(By.id("input-lastname")).sendKeys("pesingi");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("6584845154");
		driver.findElement(By.id("input-password")).sendKeys("123456");
		
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String ExpectedWarningMsg="Password confirmation does not match password!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='text-danger']")).getText(), ExpectedWarningMsg);
		
		driver.quit();
	}

}
