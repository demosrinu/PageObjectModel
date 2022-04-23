package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;

public class Homepage extends TestBase {
	
	@FindBy(xpath="//div[@class='ui left fixed vertical  icon menu sidebar-dark left-to-right']")
	WebElement leftpanel;
	
	@FindBy(xpath="//a[@href='/contacts']/following-sibling::button[@class='ui mini basic icon button']/child::i[@class='plus inverted icon']")
	WebElement addcontact;
	
	@FindBy(xpath="//div[@class='menu-item-wrapper'][5]")
	WebElement dealsbtn;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
	}
	public Contactspage AddContact() {
		Actions action = new Actions(driver);
		action.moveToElement(leftpanel).build().perform();
		addcontact.click();
		return new Contactspage();
	}
	public Dealspage AddDeals() {
		dealsbtn.click();
		return new Dealspage();
	}

}
