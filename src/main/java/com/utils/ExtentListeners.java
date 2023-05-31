package  com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.utils.setupdriver.SetupTestDriver;


public class ExtentListeners extends SetupTestDriver implements ITestListener { 
	static String fileName = "ExtentReport.html";
	   static String date= new  SimpleDateFormat("dd-MM-yyyy_hh_mm_ss").format(new Date());
	  static String xlmfilename=System.getProperty("suitefilename");
	  public static String foldername=System.getProperty("user.dir")+"\\Reports\\Report_"+xlmfilename+"_" +date;
	public static ExtentReports extent = ExtentReportConfiguration
			.createhtmlfile(foldername+"\\" + fileName);
	public ExtentTest test;
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {

		System.out.println("Starting execution..");
		
		test = extent.createTest( "ClassName: "+result.getTestClass().getRealClass().getSimpleName()+". \nTcName: "+result.getMethod().getMethodName());
		testReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			 
		}
		String methodName = result.getMethod().getMethodName();

		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";

		Markup passedLabel = MarkupHelper.createLabel(logText, ExtentColor.GREEN);

		testReport.get().pass(passedLabel);
		WebDriver driver = null ;
		 
		Object testObj=result.getInstance();
		Class classvariable=result.getTestClass().getRealClass();
		try {
			//driver=(WebDriver) classvariable.getDeclaredField("driver").get(testObj);
			//testReport.get().addScreenCaptureFromPath(takeScreenshots(driver, methodName,foldername), methodName);
		} catch (Exception e1) {
			 
			e1.printStackTrace();
		} 
		 
 
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			 
		}
		String methodName = result.getMethod().getMethodName();
		Object testObj=result.getInstance();
		Class classvariable=result.getTestClass().getRealClass();
		
		System.out.println("Failed");
		StackTraceElement[] excepionMessage = result.getThrowable().getStackTrace();
		String excepionMessage2 = result.getThrowable().getMessage();
		StringBuilder sb=new StringBuilder(); 
		for (int i = 0; i < excepionMessage.length; i++) { 		                   
			 sb.append(excepionMessage[i]);
			 sb.append("\n");
        } 
		if(excepionMessage2.length()>0) {
		sb.append(excepionMessage2);
		 sb.append("\n");
		}
		testReport.get()
		.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:  Click to see"
				+ "</font>" + "</b >" + "</summary>" + sb.toString().replaceAll("\n", "<br>") + "</details>"
				+ " \n");
		

		String failureLogg = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " FAILED" + "</b>";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		
		testReport.get().log(Status.FAIL, m);

		try {
			driver=(WebDriver) classvariable.getDeclaredField("driver").get(testObj);
			testReport.get().addScreenCaptureFromPath(takeScreenshots(driver, methodName,foldername), methodName);
		} catch (Exception e1) {
			 
			e1.printStackTrace();
		} 

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);

	}

	 

	public void onFinish(ITestContext context) {

		System.out.println("Stopping execution..");
		if (extent != null) {

			extent.flush();
		}

	}
	
 
	 public ThreadLocal<ExtentTest> getTest() {
	
	return testReport;
   } 

	

}
