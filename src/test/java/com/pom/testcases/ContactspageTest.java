package com.pom.testcases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.Contactspage;
import com.pom.pages.Homepage;
import com.pom.pages.Landingpage;
import com.pom.pages.Loginpage;
import com.pom.util.TestUtil;

public class ContactspageTest extends TestBase{
	
	Homepage homepage;
	Landingpage landingpage;
	Loginpage loginpage;
	Contactspage contactspage;
	
	public ContactspageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new Landingpage();
		loginpage = landingpage.beforelogin();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.AddContact();
	}
	
	@Test
	public void CreateContactTest() {
		contactspage.createcontact();
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) throws Exception {
		if(ITestResult.FAILURE==result.getStatus()) {
			TestUtil.CaptureScreenshot(driver, result.getName());
		}else if(ITestResult.SKIP==result.getStatus()) {
			TestUtil.CaptureScreenshot(driver, result.getName());
		}
		driver.quit();
	}

}
