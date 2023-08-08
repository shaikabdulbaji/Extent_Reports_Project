package b21addScreenCaptureFromPath;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class aSample {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
	    ExtentTest eTest = extent.createTest("Test1");
	    
		eTest.log(Status.INFO, "Test1 is Started and Navigated to Homepage");
	    eTest.addScreenCaptureFromBase64String(takeScreenshot(), "TNinja Homepage");
	    
	    WebElement search = driver.findElement(By.name("search"));
	    search.sendKeys("HP");
	    search.sendKeys(Keys.ENTER);
	    eTest.addScreenCaptureFromPath(takeScreenshotAndReturnPath("HP Search"), "HPProductSearch");
	    
	    eTest.log(Status.INFO, "Test1 Execution is Completed");
	    
		extent.flush();

		driver.quit();
		
		Desktop.getDesktop().browse(file.toURI());
		
	}	
	
	
	
	//Oneway of taking screensot
	//Base64 will not show preview as normal screenshot
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
