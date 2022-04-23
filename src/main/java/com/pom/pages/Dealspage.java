package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;

public class Dealspage extends TestBase{
	
	@FindBy(xpath="//a[@href='/deals/targets/']")
	WebElement ManageTargetsBtn;
	
	public Dealspage() {
		PageFactory.initElements(driver, this);
	}
	
	public SalesTargetsPage newDeals() {
		ManageTargetsBtn.click();
		return new SalesTargetsPage();
	}

}
