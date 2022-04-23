package com.pom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.Dealspage;
import com.pom.pages.Homepage;
import com.pom.pages.Landingpage;
import com.pom.pages.Loginpage;

public class DealspageTest extends TestBase{
	
	Landingpage landingpage;
	Loginpage loginpage;
	Homepage homepage;
	Dealspage dealspage;
	
	public DealspageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new Landingpage();
		loginpage = landingpage.beforelogin();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealspage = homepage.AddDeals();
	}
	
	@Test
	public void TargetSales() {
		dealspage.newDeals();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		}
}
