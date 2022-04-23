package com.pom.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.Homepage;
import com.pom.pages.Landingpage;
import com.pom.pages.Loginpage;
import com.pom.util.TestUtil;

public class LoginpageTest extends TestBase{
	
	Landingpage landingpage;
	Loginpage loginpage;
	Homepage homepage;
	TestUtil testutil = new TestUtil();

	
	public LoginpageTest() {
		super();
	}
		
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new Landingpage();
		loginpage = landingpage.beforelogin();
	}
	
	@Test
	public void loginTest() {
		try {
			//Thread.sleep(3000);
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}catch(Exception e) {
		System.out.println("Unable to Locate Element: "+e.getMessage());
		}
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
			testutil.CaptureScreenshot(driver, result.getName());
		}else if(ITestResult.SKIP==result.getStatus()) {
			testutil.CaptureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
