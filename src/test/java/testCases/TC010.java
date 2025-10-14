package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC010 {
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
	public void verifyRegisterAccountWithSymbleAndColor() {

		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		WebElement FirstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		WebElement LastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		WebElement EmailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		WebElement TelephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		WebElement PasswordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
		WebElement ConfirmPasswordLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));

		String ExpectedContent = "\"* \"";
		String ExpectedColor = "rgb(255, 0, 0)";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String fnContent = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				FirstNameLabel);
		String fnColor = (String) js.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", FirstNameLabel);
		Assert.assertEquals(fnContent, ExpectedContent);
		Assert.assertEquals(fnColor, ExpectedColor);

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		String lnContent = (String) js1.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", LastNameLabel);
		String lnColor = (String) js1.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", LastNameLabel);
		Assert.assertEquals(lnContent, ExpectedContent);
		Assert.assertEquals(lnColor, ExpectedColor);

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		String EmailContent = (String) js2.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", EmailLabel);
		String EmailColor = (String) js2.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", EmailLabel);
		Assert.assertEquals(EmailContent, ExpectedContent);
		Assert.assertEquals(EmailColor, ExpectedColor);

		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		String TelephoneContent = (String) js3.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				TelephoneLabel);
		String TephoneColor = (String) js3.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", TelephoneLabel);
		Assert.assertEquals(TelephoneContent, ExpectedContent);
		Assert.assertEquals(TephoneColor, ExpectedColor);

		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		String pwdContent = (String) js4.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", PasswordLabel);
		String pwdColor = (String) js4.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", PasswordLabel);
		Assert.assertEquals(pwdContent, ExpectedContent);
		Assert.assertEquals(pwdColor, ExpectedColor);

		JavascriptExecutor js5 = (JavascriptExecutor) driver;
		String confirmpwdContent = (String) js5.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');",
				ConfirmPasswordLabel);
		String confirmpwdColor = (String) js5.executeScript(
				"return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');",
				ConfirmPasswordLabel);
		Assert.assertEquals(confirmpwdContent, ExpectedContent);
		Assert.assertEquals(confirmpwdColor, ExpectedColor);

	}

}
