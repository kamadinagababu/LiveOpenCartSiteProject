package testCases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class TC013 {
	WebDriver driver;
	@AfterMethod
    public void tearDown() {
        
            driver.quit();
    }
	@Test
	public void VerifyRegisterAccountFiledWithHeightAndWidthAligments()  {
		
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/openCartsite/");
		driver.manage().window().maximize();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		
		
		String ExpectedHeight="34px";
		String ExpectedWidth="701.25px";
		
		
	 WebElement firstNameField = driver.findElement(By.id("input-firstname"));
	 String AcutalFNamefieldHeight = firstNameField.getCssValue("height");
	 String ActualFNamefieldWidth=firstNameField.getCssValue("width");
	 
	 Assert.assertEquals(AcutalFNamefieldHeight, ExpectedHeight);
	 Assert.assertEquals(ActualFNamefieldWidth, ExpectedWidth);
	 firstNameField.sendKeys("");
	 WebElement continueBtn = driver.findElement(By.xpath("//input[@value='Continue']"));
	 continueBtn.click();
	 
	 String ExpectedWarningMsg="First Name must be between 1 and 32 characters!";
	 Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(), ExpectedWarningMsg);
	 

	 
	 //.........
	 
	 WebElement lastNameField = driver.findElement(By.id("input-lastname"));
	 String AcutalLNamefieldHeight = lastNameField.getCssValue("height");
	 String ActualLNamefieldWidth=lastNameField.getCssValue("width");
	 
	 Assert.assertEquals(AcutalLNamefieldHeight, ExpectedHeight);
	 Assert.assertEquals(ActualLNamefieldWidth, ExpectedWidth);
	 
	 lastNameField.sendKeys("");
	 driver.findElement(By.xpath("//input[@value='Continue']")).click();
	 String ExpectedLastNameWarningMsg="Last Name must be between 1 and 32 characters!";
	 
	
	 WebElement lastNameErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	 ));
	 String actualText = lastNameErrorMsg.getText();

	 Assert.assertEquals(actualText, ExpectedLastNameWarningMsg);
	 
	
	 
	 //........
	 
	 WebElement emailField = driver.findElement(By.id("input-email"));
	 String AcutalEmailfieldHeight = emailField.getCssValue("height");
	 String ActualEmailfieldWidth=emailField.getCssValue("width");
	 
	 Assert.assertEquals(AcutalEmailfieldHeight, ExpectedHeight);
	 Assert.assertEquals(ActualEmailfieldWidth, ExpectedWidth);
	 
	 emailField.sendKeys("");
	 driver.findElement(By.xpath("//input[@value='Continue']")).click();
	 String ExpectedEmaailWarningMsg="E-Mail Address does not appear to be valid!";
	
	 
	 WebElement EmailErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	 ));
	 String actualTextEmail = EmailErrorMsg.getText();

	 Assert.assertEquals(actualTextEmail, ExpectedEmaailWarningMsg);
	 
	 //......
	
	 WebElement TelephoneField = driver.findElement(By.id("input-telephone"));
	 String AcutalTelephonefieldHeight = TelephoneField.getCssValue("height");
	 String ActualTelephonefieldWidth=TelephoneField.getCssValue("width");
	 
	 Assert.assertEquals(AcutalTelephonefieldHeight, ExpectedHeight);
	 Assert.assertEquals(ActualTelephonefieldWidth, ExpectedWidth);
	 
	 TelephoneField.sendKeys("");
	 driver.findElement(By.xpath("//input[@value='Continue']")).click();
	 String ExpectedTelephoneWarningMsg ="Telephone must be between 3 and 32 characters!";
	
	 WebElement TelephoneErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	 ));
	 String actualTextTelephone = TelephoneErrorMsg.getText();

	 Assert.assertEquals(actualTextTelephone, ExpectedTelephoneWarningMsg);
	 
	 //.......
	 
	 WebElement passwordField = driver.findElement(By.id("input-password"));
	 String AcutalPwdfieldHeight = passwordField.getCssValue("height");
	 String ActualPwdfieldWidth=passwordField.getCssValue("width");
	 
	 Assert.assertEquals(AcutalPwdfieldHeight, ExpectedHeight);
	 Assert.assertEquals(ActualPwdfieldWidth, ExpectedWidth);
	 

	 
	 driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("");
	 driver.findElement(By.xpath("//input[@value='Continue']")).click();
	 String ExpectedPasswordWarningMsg ="Password must be between 4 and 20 characters!";
	 
	
	 WebElement PasswordErrorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	     By.xpath("//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	 ));
	 String actualTextPassword = PasswordErrorMsg.getText();
	 Assert.assertEquals(actualTextPassword, ExpectedPasswordWarningMsg);
	 
	 //.....
	 WebElement ConfirmpasswordField = driver.findElement(By.id("input-confirm"));
	 String AcutalConfirmPwdfieldHeight = ConfirmpasswordField.getCssValue("height");
	 String ActualConfirmPwdfieldWidth=ConfirmpasswordField.getCssValue("width");
	 Assert.assertEquals(AcutalConfirmPwdfieldHeight, ExpectedHeight);
	 Assert.assertEquals(ActualConfirmPwdfieldWidth, ExpectedWidth);
	
		
	}
}
