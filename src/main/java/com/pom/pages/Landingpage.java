package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;
import com.pom.util.TestUtil;

public class Landingpage extends TestBase{
	TestUtil testutil=new TestUtil();
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement Loginlink;
	
	@FindBy(xpath="//img[@class='img-responsive']/ancestor::a[@class='navbar-brand']")
	WebElement CRMlogo;
	
	@FindBy(linkText="Sign Up")
	WebElement SignUplink;
	
	@FindBy(linkText="Pricing")
	WebElement Pricinglink;
	
	@FindBy(linkText="Features")
	WebElement Featureslink;
	
	@FindBy(linkText="Customers")
	WebElement Customerslink;
	
	@FindBy(xpath="//img[@src='/images/Android.png']")
	WebElement Androidlink;
	
	@FindBy(xpath="//a[contains(text(),'Go Top')]")
	WebElement GoTopBtn;
	
	@FindBy(linkText="Terms & Conditions")
	WebElement TnCBtn;
	
	@FindBy(xpath="//*[contains(text(),'Alerts & Reminders')]")
	WebElement AnRtext;
	
	@FindBy(xpath="//button[@data-slide='next']")
	WebElement slidenextBtn;
	
	public Landingpage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCRMlogo() {
		return CRMlogo.isDisplayed();
	}
	
	public String validateLandingpageTitle() {
		return driver.getTitle();
	}
	
	public Loginpage beforelogin() {
		
		//testutil.switchToFrame();
		Loginlink.click();
		return new Loginpage();
	}
	
	public Registrationpage beforeSignUp() {
		//testutil.switchToFrame();
		SignUplink.click();
		return new Registrationpage();
	}
	
	public Pricingpage Pricing() {
		//testutil.switchToFrame();
		Pricinglink.click();
		return new Pricingpage();
	}
	
	public Featurespage Features() {
		//testutil.switchToFrame();
		Featureslink.click();
		return new Featurespage();
	}
	
	public Customerspage Customers() {
		//testutil.switchToFrame();
		Customerslink.click();
		return new Customerspage();
	}
	
	public AppInstallpage Android() {
		//testutil.switchToFrame();
		Androidlink.click();
		return new AppInstallpage();
	}
	
	public void GoTop() {
		//testutil.switchToFrame();
		GoTopBtn.isDisplayed();
	}
	
	public PrivacyAgreementpage TnC() {
		//testutil.switchToFrame();
		TnCBtn.click();
		return new PrivacyAgreementpage();
	}
	
	public void validateAlertsnReminders() {
		System.out.println(AnRtext.getText());
	}
	
	public void verifyslidebtn() {
		slidenextBtn.click();
	}
}
