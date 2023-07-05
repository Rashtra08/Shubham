package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility
{
	

	//commonly used methods
	//screenshot
	//scrolling
	//reading data from exel
	//wait 
	
	public static void TakeScreenshot(WebDriver driver,String filename) throws IOException
	{
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\rasht\\eclipse-workspace\\PolicyBazaar\\screenshot\\"+filename+".png");
		FileHandler.copy(source, dest);
		Reporter.log("Taking Screenshot",true);
		Reporter.log("Screenshot location is"+dest,true);
	}
	
	public static void scrollIntoView(WebDriver driver,WebElement element)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0],scrollIntoView(true)", element);
		Reporter.log("Taking scrollintoview",true);
	}
	
	public static  String readingData(int rownum ,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream myfile = new FileInputStream("E:\\Software Testing\\New folder (2)\\Book3.xlsxC:\\Users\\rasht\\eclipse-workspace\\PolicyBazaar\\excelSheet");
		String values = WorkbookFactory.create(myfile).getSheet("Sheet3").getRow(rownum).getCell(cellnum).getStringCellValue();
		Reporter.log("reading data from exel row num "+rownum+" cell num is"+cellnum+" ",true);
	   return values;
	}
	
	public static void Wait(int waitTime) throws InterruptedException
	{
		Reporter.log("waiting time is"+waitTime+" mili second",true);
		Thread.sleep(waitTime);
	}
	
	public static String readingDataFromProperty(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\rasht\\eclipse-workspace\\Feb18_selenium\\myProperty.properties");
		prop.load(myFile);
		
		String values = prop.getProperty(key);
		return values;
		
	
	}

}
