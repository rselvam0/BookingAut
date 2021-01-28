package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
	
	public WebDriver driver;
	
	By currentUser = By.cssSelector("[class='navbar-current-user']");
	
	public portalHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;	
	}

	public WebElement getCurrentUser() {
		return driver.findElement(currentUser); 
	}
}
