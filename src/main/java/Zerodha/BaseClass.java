package Zerodha;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class BaseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	// fetching test par ameters from mysql database

	public WebDriver initDriver() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {


		String browser = "chrome";
		String url = "https://indigo-testing.shireburn.com/";
		if (browser.equals("chrome")) {
			// System.out.println("Test initiated using chrome browser");
			log.info("Test initiated using chrome browser");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			// System.out.println(url);
			driver.get(url);
			log.info(driver.getTitle());

		}

		if (browser.equals("IE")) {
			System.out.println("Test initiated using IE  browser");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public void screenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver; // taking screenshot with help of driver
		File source = ts.getScreenshotAs(OutputType.FILE); // saving screenshot to a File
		String destinationFile = System.getProperty("user.dir") + "\\Reports\\" + testCaseName + ".png"; //creating aPNG filewith dynamic methodname and webdriverinstance

		FileUtils.copyFile(source, new File(destinationFile)); // Transferring PNG file from source to Destination
																// location in project folder
		System.out.println("Error screenshot attached with " + testCaseName);
	}

}