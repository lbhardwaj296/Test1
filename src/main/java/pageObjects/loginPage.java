package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	By emailText = By.cssSelector("input[type='email']");
	By nextBtn = By.cssSelector("button[type='submit']");
	By passText = By.cssSelector("input[type='password']");
	By loginBtn = By.xpath("//div[@class='pb-button-group']/div/div[2]/button");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmailText() {
		return driver.findElement(emailText);
	}
	
	public WebElement getNextBtn() {
		return driver.findElement(nextBtn);
	}
	
	public WebElement getPassText() {
		return driver.findElement(passText);
	}
	
	public WebElement getloginBtn() {
		return driver.findElement(loginBtn);
	}
	
	

}
