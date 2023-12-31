package b11Different_Logs_and_their_Levels_in_Extent_Reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*  
 * Status.INFO --> will give information.
 * Status.PASS --> will give passed test information.
 * Status.FAIL --> will give failed test information.
 * Status.SKIP --> will give skipped test information.
 * Status.WARNING --> will give warning information.
   In the above 5 staus messages the priority goes to
   1. If we execute this test the 1st priority goes to  Status.FAIL
   2. Then we comment that "fail" status and execute test the 2nd priority goes to Status.SKIP
   3. Then we comment that "skip" status and execute test the 3rd priority goes to Status.WARNING
   4. Then we comment that "warning" status and execute test the 4th priority goes to Status.PASS
   5. Then we comment that "pass" status and execute test the 3rd priority goes to Status.INFO
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		ExtentTest eTest1 = extent.createTest("Test1");
		
		eTest1.log(Status.INFO, "Test1 got Information");
//		eTest1.log(Status.PASS, "Test1 got Passed");
//		eTest1.log(Status.SKIP, "Test1 got Skipped");
//		eTest1.log(Status.WARNING, "Test1 got Warning");
//		eTest1.log(Status.FAIL, "Test1 got Failed");
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
