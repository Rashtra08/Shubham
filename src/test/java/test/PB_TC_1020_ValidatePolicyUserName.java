package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import pom.MyAccountPage;
import pom.PolicyLogin;
import utility.Utility;

@Listeners(test.Listener.class)
public class PB_TC_1020_ValidatePolicyUserName extends Base
{
	PolicyLogin login;
	MyAccountPage myAcc;
	String TCID ="PB_TC1234";
	
	@BeforeClass
	public void launchPolicyBazar() throws InterruptedException, IOException
	{
		Utility.Wait(100);
		launchBrowserUsingPropertyFile();
		login=new PolicyLogin(driver);
		 myAcc=new MyAccountPage(driver);
	}
	
	@BeforeMethod
	public void loginPolicyBazar() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.Wait(1000);
		login.clickOnSignInButtonHomePage();
		Utility.Wait(1000);
		login.enterMobileNumber(Utility.readingDataFromProperty("mobNum"));
		Utility.Wait(1000);
		login.clickOnsignInWithPassword();
		Utility.Wait(1000);
		login.enterPasswordField(Utility.readingDataFromProperty("pwd"));
		Utility.Wait(1000);
		login.clickOnsignInBtn();
		Utility.Wait(1000);
		login.clickOnMyAccount();
		Utility.Wait(1000);
		login.clickOnmyProfileButton();
		Utility.Wait(1000);
		
		//switching to new page
		Set<String> allpageID = driver.getWindowHandles();
		List<String> al=new ArrayList<>(allpageID);
		
		//String mainPageID = al.get(0);
		//String childPageID = al.get(1);
		
		driver.switchTo().window(al.get(1));
		Reporter.log("switching to child page",true);
		Utility.Wait(200);
	
	
	}
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException, InterruptedException
  {
	  Assert.assertEquals(myAcc.getActualUserName(), Utility.readingDataFromProperty("UN"),"TC is failed actualUN and EXPUN is not matched");
      Utility.TakeScreenshot(driver,myAcc.getActualUserName()+TCID );
	  Utility.Wait(2000);
  }
  
  @AfterMethod
  public void closePolicyBazar() throws InterruptedException
  {
	  myAcc.ClickOnLogoutButton();
	  Utility.Wait(1000);
	  
  }
  
  @AfterClass
  public void CloseBrowser()
  {
	  closeBrowser();
  }
}
