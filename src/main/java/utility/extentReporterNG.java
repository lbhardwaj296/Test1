package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import com.aventstack.extentreports.ExtentReporter;
//import com.aventstack.extentreports.ExtentReports;

//import com.relevantcodes.extentreports.ExtentReports;

public class extentReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject() {
		
		String path = "./reports/index.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Story Weaver");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("QA", "Loveleen");
		
		return extent;
		
	}

}


