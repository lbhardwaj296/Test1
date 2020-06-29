package TestCases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.landingPage;
import pageObjects.loginPage;
import baseFiles.base;

public class HomePage extends base {
	
	public WebDriver driver;
	loginPage login_page;
	landingPage landing_page;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void startDriver() throws IOException {
			driver = initializeDriver();
			log.info("Driver initialized");
	}
	
	@Test(priority=1)
	public void translatorMenuItem() {
		driver.get(p.getProperty("url"));
		landing_page = new landingPage(driver);
		landing_page.getTranslatorMenuItem().click();
	}
	
	@Test(dataProvider="getData", priority=2)
	public void homePageNavigation(String username, String password) throws IOException {
	
	System.out.println(p.getProperty("url"));
	driver.get(p.getProperty("url"));
	landing_page = new landingPage(driver);
	landing_page.getsignIn_signUp().click();
	
	log.info("Sign up pop up clicked");
	
	login_page = new loginPage(driver);
	login_page.getEmailText().sendKeys(username);
	login_page.getNextBtn().click();
	login_page.getPassText().sendKeys(password);
	login_page.getloginBtn().click();
	
	//Assert.assertTrue(false);
	
	log.info("Login button clicked");
	
	}
	
	
	
	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[2][2];
		
		data[0][0] = "loveleen@yopmail.com";
		data[0][1] = "password1";
		
		data[1][0] = "loveleen@yopmail.com";
		data[1][1] = "password";
		return data;
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		driver.close();
		log.info("Driver closed");
	}
	
	

}
