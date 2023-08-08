package b28Adding_System_Environment_details_to_Extent_Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aSample {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException{
		
		Properties prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\b28Adding_System_Environment_details_to_Extent_Reports\\data.properties");
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		extent.setSystemInfo("Application URL Info", prop.getProperty("url"));
		
		
	    ExtentTest eTest = extent.createTest("Test1");
	    
		eTest.log(Status.INFO, "Test1 is Started and Navigated to Homepage");
	    //eTest.addScreenCaptureFromBase64String(takeScreenshot(), "TNinja Homepage");
		   
	    WebElement search = driver.findElement(By.name("search"));
	    search.sendKeys("HP");
	    search.sendKeys(Keys.ENTER);
	    //eTest.addScreenCaptureFromPath(takeScreenshotAndReturnPath("HP Search"), "HPProductSearch");
	    
	    //For attaching screenshot at log level
	    eTest.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshotAndReturnPath("HP Search"), "HPProductSearch").build());
	    
	    
	    eTest.log(Status.INFO, "Test1 Execution is Completed");
	    
		extent.flush();

		driver.quit();
		
		Desktop.getDesktop().browse(file.toURI());
		
	}	
	
	
	
	//Oneway of taking screensot
	//Base64 will not show preview as normal Screenshot
	public static String takeScreenshot() throws IOException
	{
		
		String base64Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);		
		return base64Screenshot;
	}

	
	//Anotherway of taking screensot
	public static String takeScreenshotAndReturnPath(String filename) throws IOException
	{
		
		File sourceScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desScreenshotfilePath = new File(System.getProperty("user.dir")+"\\screenshots\\"+filename+".png");
		FileUtils.copyFile(sourceScreenshot, desScreenshotfilePath);
		
		return desScreenshotfilePath.getAbsolutePath();
	}
}
