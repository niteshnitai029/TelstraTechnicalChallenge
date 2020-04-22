package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilityPackage.LoggerForTestCases;

public class ConfigFileReader {
	private Properties properties;
	private WebDriver driver;
	 private final String propertyFilePath= "Configuration//configuration.properties";
	 
	 public ConfigFileReader(){
		 BufferedReader reader;
		 try {
			 reader = new BufferedReader(new FileReader(propertyFilePath));
			 properties = new Properties();
			 try {
				 properties.load(reader);
				 reader.close();
			 } catch (IOException e) {
				 e.printStackTrace();
			 }
		 } catch (FileNotFoundException e) {
			 e.printStackTrace();
			 throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		 } 
	 }
	 
	 public String getApplicationUrl() {
	 String url = properties.getProperty("url");
	 if(url != null) 
		 return url;
	 	else 
	 		throw new RuntimeException("url not specified in the properties file.");
	 }
	 
	 public WebDriver getBrowser() {
		 String browser = properties.getProperty("browser");
		 if(browser.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			 LoggerForTestCases.info("Chrome driver for testing is loaded successfully");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
		 }else if (browser.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
			 LoggerForTestCases.info("Firefox driver for testing is loaded successfully");
			 driver = new FirefoxDriver();
			 driver.manage().window().maximize();
		 }else if (browser.equalsIgnoreCase("IE")) {
			 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\Drivers\\IEDriverServer.exe");
			 LoggerForTestCases.info("Internet Explorer driver for testing is loaded successfully");
			 driver = new InternetExplorerDriver();
			 driver.manage().window().maximize();
		 }
		return driver;
	 }
	 
	 public WebDriver openAmazonSite() {
		 driver.get(getApplicationUrl());
			LoggerForTestCases.info("Amazon URL loaded successfully");
			return driver;
	 }
}
	 

	

