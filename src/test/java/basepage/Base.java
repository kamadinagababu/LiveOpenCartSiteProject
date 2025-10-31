package basepage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	WebDriver driver;
	public WebDriver OpenBrowserAndApplication(){
		String browserName="chrome";
		if(browserName.equals("chrome"))
		{
		 driver=new ChromeDriver();
		}
		else if(browserName.equals("edge"))
		{
			 driver=new EdgeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("browser does not match");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		return driver;
	}

}
