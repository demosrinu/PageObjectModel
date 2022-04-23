package com.pom.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.pom.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	private static ChromeOptions co;
	private static FirefoxOptions fo;
	private static EdgeOptions eo;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("F:\\Selenium_Practice\\PageObjectModel\\src\\main\\java\\com\\pom\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			co = new ChromeOptions();
			WebDriverManager.chromedriver().setup();	
			driver = new ChromeDriver(co); 
			co.addArguments("--disable-notifications");
		}
		else if(browserName.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			fo = new FirefoxOptions();
			driver = new FirefoxDriver(fo); 
			fo.addArguments("--disable-notifications");
			
		}else if(browserName.equals("edge")){
			WebDriverManager.edgedriver().setup();
			eo = new EdgeOptions();
			driver = new EdgeDriver(eo);
			eo.addArguments("--disable-notifications");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));
		
		driver.get(prop.getProperty("url"));
		
	}	
}
