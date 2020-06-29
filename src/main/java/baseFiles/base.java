package baseFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public WebDriver driver;
	public Properties p;
	
	public WebDriver initializeDriver() throws IOException {
		p = new Properties();
		FileInputStream fis = new FileInputStream("//Users//loveleenbhargava//eclipse-workspace//SW_Prac_Automation//resources//object.properties");
		p.load(fis);
		String browserName = p.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "//Users//loveleenbhargava//eclipse-workspace//SW_Prac_Automation//chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserName=="Firefox") {
			
		}
		else if(browserName=="IE") {
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(System.getProperty("user.dir"));
		String destinationFilePath = "./reports/" + testMethodName + ".png";
		System.out.println(destinationFilePath);
		String returnPath = System.getProperty("user.dir")+destinationFilePath;
		FileUtils.copyFile(source, new File(destinationFilePath));
		return returnPath;
	}

}
