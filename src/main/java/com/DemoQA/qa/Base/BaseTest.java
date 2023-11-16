package com.DemoQA.qa.Base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BaseTest {

	public static Properties prop;
	public static WebDriver driver;
	
	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("G:\\eclipse\\DemoQa\\src\\main\\java\\com\\DemoQA\\qa\\ConfigProperties\\Config.Properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void launchApp() {
		String browserName = prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "G:\\eclipse\\DemoQa\\Drivers\\chromedriver.exe");
		    driver=new ChromeDriver();
		}else if(browserName.contains("firefox")) {
			driver=new FirefoxDriver();
			
		}else if(browserName.contains("IE")) {
			driver=new InternetExplorerDriver();
			
		}
		   driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			//Implicit TimeOuts
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			//PageLoad TimeOuts
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
			//Launching the URL
			driver.get(prop.getProperty("url"));
		}
}
