package testCases;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC021 {
	WebDriver driver;
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	
	}
	@Test(dataProvider="environmentData")
	public void verifyRegisterAccopuntInDefferentTestEnvironments(String env) {
	 		
	 		String BrowserName=env;
	 	
	 		if(BrowserName.equals("chrome"))
	 		{
	 			 driver=new ChromeDriver();
          	}
	 		else if(BrowserName.equals("edge"))
	 		{
	 		 driver=new EdgeDriver();
	 		}
	 		else if(BrowserName.equals("firefox"))
	 		{
	 		 driver=new FirefoxDriver();
	 		}
	 		else {
	 			System.out.println("browser does not match");
	 		}
	 		
	 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 		driver.get("https://tutorialsninja.com/demo/");
	 		driver.manage().window().maximize();
	 		
	 		
	 		driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
			driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();

			driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("nagababu");
			driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("kamadi");
			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(commonUtils.generateRandomEmail());
			driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("9885065125");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Chaithu@111");
			driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Chaithu@111");
			driver.findElement(By.xpath("//input[@name='agree']")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
				
	}

@DataProvider(name="environmentData")
public  Object[][] PassTestEnvironments()
{
	Object [][] env= {{"chrome"},{"edge"},{"firefox"}};
	return env;
}
}

