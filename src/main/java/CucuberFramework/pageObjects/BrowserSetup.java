package CucuberFramework.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserSetup {

	public static WebDriver driver = null;
	

	Properties global_data = new Properties();

	public void driverSetup() throws IOException {

		// global_data=new Properties();
		FileInputStream file_global = new FileInputStream(
				"C:\\Users\\User\\Desktop\\CucumberFramework_adidas\\CucuberFramework\\src\\main\\java\\CucuberFramework\\pageObjects\\global.properties");
		global_data.load(file_global);
		// 
		String browserName = (String)System.getProperty("browserName");
		System.out.println(browserName);

		if (global_data.getProperty("browser").contains("firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			//System.setProperty("webdriver.gecko.driver",
				//	"C:\\Users\\User\\Desktop\\CucumberFramework\\CucuberFramework\\src\\test\\java\\CucuberFramework\\resources\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver",global_data.getProperty("firefox_driver_path"));
			driver = new FirefoxDriver(firefoxOptions);
		} else if (global_data.getProperty("browser").contains("chrome")) {
			//System.setProperty("webdriver.chrome.driver",
				//	"C:\\Users\\User\\Desktop\\CucumberFramework\\CucuberFramework\\src\\test\\java\\CucuberFramework\\resources\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",global_data.getProperty("chrome_driver_path"));
			driver = new ChromeDriver();
		} else {
			// Internetexplorer
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
	}



	public void startNavigation() {
		driver.get(global_data.getProperty("url"));
	}

}
