package com.pom.util;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pom.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 15;
	public static long IMPLICITLY_WAIT = 15;
	
	
	public void switchToFrame() {
		
		WebElement fr = driver.findElement(By.name("intercom-borderless-frame"));
		driver.switchTo().frame(fr).findElement(By.xpath("//div[@aria-label='Dismiss']")).click();
		driver.switchTo().defaultContent();
	}
	
	public void SettingChromeOptions() {
		Map prefs = new HashMap();
		prefs.put("profile.default_content_setting_values.notifications", 1);
		ChromeOptions co= new ChromeOptions();
		co.setExperimentalOption("prefs", prefs);
		
	}
	
	public void clickElementByJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static String CaptureScreenshot(WebDriver driver, String ScreenshotName) throws Exception {
			
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("C:\\Users\\sandavenisrinivas\\eclipse-workspace\\PageObjectModel\\Screenshots"+ScreenshotName+".png");
		File destFile = new File(destPath);
		FileUtils.copyDirectory(sourceFile, destFile );
		return destPath;
	}
	
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void AlertDismiss(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public void ActionMoveToElementClick(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).click().build().perform();
}
	public void selectDropDownValueWithoutSelect(String categoryxpath, String value) {
		List<WebElement> optionsList = driver.findElements(By.xpath(categoryxpath));
		System.out.println(optionsList.size());
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
