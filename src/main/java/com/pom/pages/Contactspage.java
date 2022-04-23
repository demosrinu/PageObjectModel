package com.pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.base.TestBase;
import com.pom.util.TestUtil;

public class Contactspage extends TestBase{
		
	TestUtil testutil = new TestUtil();
	
	@FindBy(name="first_name")
	WebElement fname;
	
	@FindBy(name="last_name")
	WebElement lname;
	
	@FindBy(xpath="//input[@class='search']/parent::div[@name='company']")
	WebElement searchcompany;
	
	@FindBy(xpath="//div[@class='selected item addition']")
	WebElement addcompany;
	
	@FindBy(xpath="//div[@name='category' and @role='listbox']")
	WebElement category;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement Email;
	
	@FindBy(name="do_not_text")
	WebElement dnd;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement savebtn;
	
	@FindBy(xpath="//button[@class='ui small fluid positive toggle button']")
	WebElement Togglebtn;
	
	@FindBy(xpath="//input[@name='middle_name']")
	WebElement Middlename;
	
	public Contactspage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createcontact() {
		
		fname.sendKeys("srinu");
		lname.sendKeys("sarala");
		searchcompany.sendKeys("futuregroup");
		//Actions builder = new Actions(driver);
		//builder.moveToElement(searchcompany).sendKeys("google");
		addcompany.click();
		//WebDriverWait wait = new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@name='company']/child::div[@class='visible menu transition']")));
		//Select sel = new Select(category);
		//sel.selectByVisibleText("Customer");
		Togglebtn.click();
		Middlename.sendKeys("sandavena");
		String categoryxpath = "//div[@name='category' and @role='listbox']";
		testutil.selectDropDownValueWithoutSelect(categoryxpath, "Customer");
		//dnd.click();
		savebtn.click();
	}
}
