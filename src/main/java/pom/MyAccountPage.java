package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccountPage 
{
	//variable
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName;
	@FindBy(className = "h_l") private WebElement logoutButton;
    
	
	//constructor
	
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//methods
	
	public String getActualUserName()
	{
		Reporter.log("get Actual User name",true);
		String actualUN = userName.getText();
	
		return actualUN;
		
	}
	public void ClickOnLogoutButton() throws InterruptedException
    {
		Reporter.log("clicking on logoutbutton",true);
		Thread.sleep(1000);
		logoutButton.click();
    }
	
	
}
