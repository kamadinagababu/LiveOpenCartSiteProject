package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepage.Base;
import utils.commonUtils;

public class TC001 extends Base {
	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver=OpenBrowserAndApplication();
		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
		driver.findElement(
				By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void AccountRigister() {

		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("nagababu");
		driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kamadi");
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(commonUtils.generateRandomEmail());
		driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9885065125");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Chaithu@111");
		driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Chaithu@111");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// validatation
		Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"))
				.isDisplayed());
		String expectedHeading = "Your Account Has Been Created!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText(),
				expectedHeading);

		String ActualproperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String ActualproperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String ActualproperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String ActualproperDetailsFour = "A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please contact us.";

		String ExpectedproperDetails = driver.findElement(By.xpath("//div[@id='content']")).getText();
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsOne));
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsTwo));
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsThree));
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsFour));
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed());

	}

}
