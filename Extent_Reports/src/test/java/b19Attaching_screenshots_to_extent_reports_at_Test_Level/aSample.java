package b19Attaching_screenshots_to_extent_reports_at_Test_Level;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * ExtentTest eTest = extent.createTest("Test1", "This Test is describing TestOne");
   "This Test is describing TestOne" --> description                                                           
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
				
		ExtentTest eTest = extent.createTest("Test1", "This Test is describing TestOne");

		eTest.log(Status.INFO, "Test1 Execution was Started");
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
