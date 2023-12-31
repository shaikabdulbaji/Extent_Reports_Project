package b15Log_Collection_Data_into_the_generated_extent_report;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/*
 * createOrderedList(list) --> we use this we get numbers in extentreport
 * createUNorderedList(list1) --> we use this we get dots in extentreport
 */

public class aSample {
	
	public static void main(String[] args) throws IOException {
	
		ExtentReports extent = new ExtentReports();
		
		File file = new File(System.getProperty("user.dir")+"\\ExtentReports\\eReport.html");
		
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
		
		extent.attachReporter(sparkReport);
				
		ArrayList<String> list = new ArrayList<String>();
		list.add("sunday");
		list.add("monday");
		list.add("tuesday");
		list.add("wednesday");
		list.add("thursday");
		list.add("friday");
		list.add("saturday");
		
		ExtentTest eTest1 = extent.createTest("Test1");

		eTest1.log(Status.INFO, MarkupHelper.createOrderedList(list));
		
		
		
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("sunday");
		list1.add("monday");
		list1.add("tuesday");
		list1.add("wednesday");
		list1.add("thursday");
		list1.add("friday");
		list1.add("saturday");
		
		ExtentTest eTest2 = extent.createTest("Test2");

		eTest2.log(Status.INFO, MarkupHelper.createUnorderedList(list1));
		
	//	---------------------------------------------------------------------------------
		
		HashSet<String> set = new HashSet<String>();
		set.add("sunday");
		set.add("monday");
		set.add("tuesday");
		set.add("wednesday");
		set.add("thursday");
		set.add("friday");
		set.add("saturday");
		
		ExtentTest eTest3 = extent.createTest("Test3");

		eTest3.log(Status.INFO, MarkupHelper.createOrderedList(set));
	
		HashSet<String> set1 = new HashSet<String>();
		set1.add("sunday");
		set1.add("monday");
		set1.add("tuesday");
		set1.add("wednesday");
		set1.add("thursday");
		set1.add("friday");
		set1.add("saturday");
		
		ExtentTest eTest4 = extent.createTest("Test4");

		eTest4.log(Status.INFO, MarkupHelper.createUnorderedList(set1));
		
		
//		---------------------------------------------------------------------------------
		
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("Firstname", "abdul");
			map.put("Lastname", "shaik");
			map.put("Experience", 16);
			map.put("Location", "hyderabad");
			
			ExtentTest eTest5 = extent.createTest("Test5");

			eTest5.log(Status.INFO, MarkupHelper.createOrderedList(map));
		
			HashMap<String, Object> map1= new HashMap<String, Object>();
			map1.put("Firstname", "shaik");
			map1.put("Lastname", "rasool");
			map1.put("Experience", 40);
			map1.put("Location", "chennai");
			
			ExtentTest eTest6 = extent.createTest("Test6");

			eTest6.log(Status.INFO, MarkupHelper.createUnorderedList(map1));
		
		extent.flush();
		
		Desktop.getDesktop().browse(file.toURI());
	}		

}
