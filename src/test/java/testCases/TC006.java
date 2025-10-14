package testCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC006 {

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
	public void verifyAcoountRigisterWithInavlidEmail() throws IOException, InterruptedException {
		driver.findElement(By.xpath("//ul[@class='list-inline']//li[@class='dropdown']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("naga");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("babu");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("chaitan12");
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9885065125");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("1234");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("1234");
		driver.findElement(By.xpath("//label[normalize-space()='Yes']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(5000);

		// take screenshot1
		File srcScreenshot1 = driver.findElement(By.xpath("//fieldset[@id='account']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir") + "\\screenshots\\ActualScreen1.png"));

		// Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\screenshots\\ExpectedScreen1.png",System.getProperty("user.dir")+"\\screenshots\\ActualScreen1.png"));

		driver.navigate().refresh();

		// driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("chaitan12@");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Thread.sleep(2000);
		// take screenshot2

		File srcScreenshot2 = driver.findElement(By.xpath("//div[@id='content']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot2, new File(System.getProperty("user.dir") + "\\screenshots\\ActualScreen2.png"));

		// Assert.assertTrue(compareTwoScreenshots(System.getProperty("user.dir")+"\\screenshots\\ExpectedScreen2.png",System.getProperty("user.dir")+"\\screenshots\\ActualScreen2.png"));

		driver.navigate().refresh();

		// driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("chaitan12@gmail");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		String expectedWarningMsgMail = "E-Mail Address does not appear to be valid!";
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]"))
						.getText(),
				expectedWarningMsgMail);

		driver.navigate().refresh();

		// driver.findElement(By.xpath("//input[@id='input-email']")).clear();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("chaitan12@gmail.");
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);

		File srcScreenshot3 = driver.findElement(By.xpath("//fieldset[@id='account']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot3, new File(System.getProperty("user.dir") + "\\screenshots\\ActualScreen3.png"));

		// Assert.assertFalse(compareTwoScreenshots(System.getProperty("user.dir")+"\\screenshots\\ExpectedScreen3.png",System.getProperty("user.dir")+"\\screenshots\\ActualScreen3.png"));

	}

	public boolean compareTwoScreenshots(String expectedPath, String actualPath) throws IOException {

		BufferedImage expectedImage = ImageIO.read(new File(expectedPath));
		BufferedImage actualImage = ImageIO.read(new File(actualPath));

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff differenceImage = imgDiff.makeDiff(expectedImage, actualImage);
		return differenceImage.hasDiff();
	}

}
