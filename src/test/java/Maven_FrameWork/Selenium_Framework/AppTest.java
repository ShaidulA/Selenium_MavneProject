
package Maven_FrameWork.Selenium_Framework;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepositry.Homepage;
import ObjectRepositry.Login;
import Utilities.CrossBrowser;
import Utilities.ExcelData;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	String data[];
	@Test
	public void valid_application() throws IOException, InterruptedException
	{
		ExtentReports report=new ExtentReports();
		ExtentSparkReporter sparkreport=new ExtentSparkReporter("C:\\Users\\owner\\Workspace\\Shaidul\\Nexxvali\\Selenium_Framework\\target\\report.html");
		ExtentTest test=report.createTest("Login Application");
		report.attachReporter(sparkreport);
		
		data=new String[5];
		test.log(Status.PASS, "user launched the browser");
		CrossBrowser br=new CrossBrowser();
		driver=br.browser_initiate();
		Homepage h=new Homepage(driver);
		h.signin();
		test.log(Status.PASS, "user has clicked on sign in");
		ExcelData d=new ExcelData();
		data=d.readExcel();
		String user=data[0];
		String pass=data[1];
		
		Login l=new Login(driver);
		l.login_credentials(user,pass);
		Thread.sleep(5000);
		test.log(Status.PASS, "user has entered valid credentials");
		report.flush();
		
	}
}
	
	
	

