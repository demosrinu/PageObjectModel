package com.pom.pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;
import com.pom.util.TestUtil;

public class Loginpage extends TestBase {
	TestUtil testutil;

	@FindBy(xpath="//div[@class='onesignal-bell-launcher-button']")
	WebElement signalbtn;

	@FindBy(name="email")
	WebElement Emailtxt;

	@FindBy(name="password")
	WebElement Passwordtxt;

	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Loginbtn;

	//initializing pageobjects
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}

	//actions
	public Homepage login(String username, String password){

		testutil= new TestUtil();
		//testutil.clickElementByJS(signalbtn);
		testutil.SettingChromeOptions();
		/*Actions act = new Actions(driver);
		act.moveToElement(signalbtn).click().build().perform();*/
		Emailtxt.sendKeys(username);
		Passwordtxt.sendKeys(password);
		Loginbtn.click();
		return new Homepage();
	}
}
