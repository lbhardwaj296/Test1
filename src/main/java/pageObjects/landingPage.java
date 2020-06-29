package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	By homeTitle = By.className("pb-site-header__brand");
	By SignIn_SignUp = By.cssSelector("span.pb-site-nav-link__title");
	By TranslatorMenuItem = By.linkText("Translate");
	
	
	public landingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getsignIn_signUp() {
		return driver.findElement(SignIn_SignUp);
	}
	
	public WebElement getTranslatorMenuItem() {
		return driver.findElement(TranslatorMenuItem);
	}
	
	public boolean getHomePageTitle() {
		if(driver.findElement(homeTitle).isDisplayed())
			return true;
		else
			return false;
	}
	
	

}
