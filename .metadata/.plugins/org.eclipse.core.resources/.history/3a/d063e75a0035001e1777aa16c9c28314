package b16Log_Highlighted_text_into_the_generated_extent_report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * eTest.log(Status.INFO, MarkupHelper.createLabel("<h1>Test1 got Started</h1>", 
                                                              ExtentColor.GREEN));
   Gives our color as our wish                                                           
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
				
		ExtentTest eTest = extent.createTest("Test1");
		eTest.log(Status.INFO, "Test1 got Started");
		eTest.log(Status.INFO, MarkupHelper.createLabel("<h1>Test1 got Started</h1>", ExtentColor.GREEN));
		
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
