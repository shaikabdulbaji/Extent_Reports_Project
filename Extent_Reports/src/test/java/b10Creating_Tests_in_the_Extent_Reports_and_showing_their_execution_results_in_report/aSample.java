package b10Creating_Tests_in_the_Extent_Reports_and_showing_their_execution_results_in_report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * If we want to open the extent report after passing the tests, right click on 
   project aand click on refresh the exent report will generate then click on that
   report it will be open in default browser.
   
 * If we don't want to do this all above procedure to see the extent report, give 
   below line after passing the tests it wil automatically open the report in default browser.
   Desktop.getDesktop().browse(file.toURI());
   
 * Status.INFO --> will give information.
 * Status.PASS --> will give passed test information.
 * Status.FAIL --> will give failed test information.
 * Status.SKIP --> will give skipped test information.
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		ExtentTest eTest1 = extent.createTest("Test1");
		eTest1.log(Status.INFO, "Chrome Browser got launched");
		eTest1.log(Status.INFO, "Chrome Browser got maximized");
		eTest1.log(Status.INFO, "Chrome Browser got serch for product");
		eTest1.log(Status.INFO, "Chrome Browser got Closed");
		eTest1.log(Status.WARNING, "Allinement is not Good");
		
		
		
		/*
		//eTest1.pass("Test1 is Passed"); //This is one way of passing the test in reports
		eTest1.log(Status.PASS, "Test1 is Passed"); //This is another way of passing the test in reports
		
		ExtentTest eTest2 = extent.createTest("Test2");
		//eTest2.fail("Test2 is Failed");
		eTest2.log(Status.FAIL, "Test2 is Failed");
		
		ExtentTest eTest3 = extent.createTest("Test3");
		//eTest3.skip("Test3 is Skipped");
		eTest3.log(Status.SKIP, "Test3 is Skipped");
		*/
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
