package com.luma.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.xml.XmlConfigurationFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.w3c.dom.DOMConfiguration;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.luma.actiondriver.Action;
import com.luma.utility.ExtentManager;
import com.luma.utility.Log;
import com.luma.utility.NewExcelLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass{
	public static Properties prop;
	public static ChromeOptions option;
	static Action Action = new Action();
	
	//for parallel execution
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public static void loadConfig() throws IOException {
		ExtentManager.setExtent();
		Log.info("log file is begin");
		
		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
//			FileInputStream ip = new FileInputStream("configuration/Config.properties");
			prop.load(ip);
			System.out.println("driver: "+ driver.get());
		}catch (FileNotFoundException e ) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void launchApp(String browserName){
		option = new ChromeOptions();
	    option.setBinary("C:\\Users\\yogit\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
	    
	    
//	    String browserName = "Firefox";
	    
	    if(browserName.equalsIgnoreCase("Chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver.set(new ChromeDriver(option));
	    }else if(browserName.equalsIgnoreCase("Firefox")) {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver.set(new FirefoxDriver());
	    }else if(browserName.equalsIgnoreCase("Edge")) {
	    	WebDriverManager.edgedriver().setup();
	    	driver.set(new EdgeDriver());
	    }
	    
	    getDriver().manage().deleteAllCookies();
	    System.out.println("cookies deleted");
	    Action.implicitWait(getDriver(), 20);
	    Action.pageLoadTimeOut(getDriver(), 50);
	    getDriver().get("https://magento.softwaretestingboard.com");
	    getDriver().manage().window().maximize();
	    getDriver().navigate().refresh();
	    
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
}

