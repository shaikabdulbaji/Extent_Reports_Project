package a9Generating_Basic_ExtentReport_without_any_Tests_using_Spark_Reporter;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * "ExtentReports" is the predefined class of ExtentReports library.
 * We want to use "ExtentSparkReports" attach this "ExtentSparkReports" to the Engine.
 * The Engine is "ExtentReports"
 
 
 * Without the below two lines the "ExtentReport" will not generate.
   extent.attachReporter(sparkReport);
   extent.flush();
 */

public class aSample {
	
	public static void main(String[] args) {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		extent.flush();
		
	}		

}
