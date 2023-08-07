package b12Log_text_in_bold_or_italic_formats_into_the_generated_extent_report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * eTest1.log(Status.INFO, "Test1 Started");  --> Print information in normal format.
 
 * eTest1.log(Status.INFO, "<b> Test1 Started </b>"); --> Print information in bold format.
		
 * eTest1.log(Status.INFO, "<i> Test1 Started </i>"); --> Print information in italic format.
		
 * eTest1.log(Status.INFO, "<u> Test1 Started </u>"); --> Print information in underline format.
		
 * eTest1.log(Status.INFO, "<h1> Test1 Started </h1>"); --> Print information in heading format.
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		ExtentTest eTest1 = extent.createTest("Test1");
		
		eTest1.log(Status.INFO, "<b> Test1 Started </b>");
		
		eTest1.log(Status.INFO, "<i> Test1 Started </i>");
		
		eTest1.log(Status.INFO, "<u> Test1 Started </u>");
		
		eTest1.log(Status.INFO, "<h1> Test1 Started </h1>");
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
