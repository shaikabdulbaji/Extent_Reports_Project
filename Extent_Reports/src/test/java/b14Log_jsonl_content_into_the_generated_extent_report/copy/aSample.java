package b14Log_jsonl_content_into_the_generated_extent_report.copy;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * The below line is used to print the JSON(Which is given) in ExtentReport
   eTest1.log(Status.INFO, MarkupHelper.createCodeBlock(jsonContent, CodeLanguage.JSON));
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
		
		String jsonContent = "[\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"Abdul\",\r\n"
				+ "    \"age\": 30\r\n"
				+ "  },\r\n"
				+ "  {\r\n"
				+ "    \"name\": \"Shaik\",\r\n"
				+ "    \"age\": 31\r\n"
				+ "  }\r\n"
				+ "]";
		
		
		ExtentTest eTest1 = extent.createTest("Test1");
		
		eTest1.log(Status.INFO, MarkupHelper.createCodeBlock(jsonContent, CodeLanguage.JSON));
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
