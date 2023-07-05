package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PolicyLogin 
{
	// Variable
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInButtonHomePage;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberFiled;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signInBtn;
	@FindBy(xpath = "//div[text()='My Account']") private WebElement myAccount;
	@FindBy(xpath = "//span[text()=' My profile ']") private WebElement myProfileButton;
	
	//Constructor
	
	public PolicyLogin(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//methods
	
	public void clickOnSignInButtonHomePage()
	{
		Reporter.log("click on Singn  inhome page button",true);
		signInButtonHomePage.click();
	}
	
	public void enterMobileNumber(String mob) throws InterruptedException
	{
		Reporter.log("enter the mobile no.",true);
		Thread.sleep(500);
		mobileNumberFiled.sendKeys(mob);
	}
	public void clickOnsignInWithPassword()
	{
		Reporter.log("clicking on Signwithpassword  button",true);
		signInWithPassword.click();
	}
	
	public void enterPasswordField(String pwd)
	{
		Reporter.log("enter the password ",true);
		passwordField.sendKeys(pwd);
	}

    public void clickOnsignInBtn()
    {
    	Reporter.log("clicking on Singn in button",true);
    	signInBtn.click();
    }
    public void clickOnMyAccount() throws InterruptedException
    {
    	Reporter.log("clicking on my account in button",true);
    	Thread.sleep(500);
    	myAccount.click();
    }
    public void clickOnmyProfileButton()
    {
    	Reporter.log("clicking on myProfile button",true);
    	myProfileButton.click();
    }
}
