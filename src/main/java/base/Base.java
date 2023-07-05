package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;

public class Base
{
	//  driver and browser setup
	static protected WebDriver driver;
	public void launchBrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://www.policybazaar.com/");
		Reporter.log("launching browser.....",true);
	}	
		
	public void launchBrowserUsingPropertyFile() throws IOException
	{
		driver=new ChromeDriver();
		driver.get(Utility.readingDataFromProperty("url"));
		Reporter.log("launching browser.....",true);
		
		
	}

	public void closeBrowser()
	{
		Reporter.log("closing browser.....",true);
		driver.quit();
	}

}
