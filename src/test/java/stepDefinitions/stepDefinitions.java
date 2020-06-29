package stepDefinitions;
import java.io.IOException;

import org.testng.Assert;

import baseFiles.base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.landingPage;
import pageObjects.loginPage;

public class stepDefinitions extends base{
	landingPage landing_page;
	loginPage login_page;

	@Given("^I open Storyweaver$")
	public void open_Storyweaver() throws IOException {
		driver = initializeDriver();
		driver.get(p.getProperty("url"));
		//System.out.println("Navigation");
		
	}
	
	@Then("^I should navigate to Home Page successfully$")
	public void navigate_To_Storyweaver() {
		landing_page = new landingPage(driver); 
		Assert.assertTrue(landing_page.getHomePageTitle());
	}
	
	@Given("^I login to Storyweaver with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_To_Storyweaver_Site(String Email, String Password) {
		landing_page = new landingPage(driver);
		landing_page.getsignIn_signUp().click();
		login_page = new loginPage(driver);
		login_page.getEmailText().sendKeys(Email);
		login_page.getNextBtn().click();
		login_page.getPassText().sendKeys(Password);
		login_page.getloginBtn().click();	
	}
	
	@And("^I close the browser$")
	public void close_Browser() {
		driver.quit();
	}
	

}
