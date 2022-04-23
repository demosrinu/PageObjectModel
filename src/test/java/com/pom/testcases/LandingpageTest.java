package com.pom.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pom.base.TestBase;
import com.pom.pages.Landingpage;

public class LandingpageTest extends TestBase{
		
	Landingpage landingpage;
	
	public LandingpageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingpage = new Landingpage();
	}
	
	@Test
	public void beforeloginTest() {
		landingpage.beforelogin();
	}
	
	@Test
	public void beforeSignUpTest() {
		landingpage.beforeSignUp();
	}
	
	@Test
	public void PricingTest() {
		landingpage.Pricing();
	}
	
	@Test
	public void FeaturesTest() {
		landingpage.Features();
	}
	
	@Test
	public void CustomersTest() {
		landingpage.Customers();
	}
	
	@Test
	public void AndroidTest() {
		landingpage.Android();
	}
	
	@Test
	public void GoTopBtnTest() {
		landingpage.GoTop();
	}
	
	@Test
	public void TnCTest() {
		landingpage.TnC();
	}
	
	@Test
	public void AlertsnRemindersTest() {
		landingpage.validateAlertsnReminders();
	}
	
	@Test
	public void slidenextBtnTest() {
		landingpage.verifyslidebtn();
	}
	
	@Test
	public void LandingpageTitleTest() {
		String title = landingpage.validateLandingpageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
		System.out.println(title);
	}
	
	@Test
	public void CRMlogoTest() {
		boolean flag = landingpage.validateCRMlogo();
		Assert.assertTrue(flag);		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
