package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//div/div/h3/span");
	private By navigationBar = By.cssSelector("[class='navigation clearfix']");
	private By courseHeader = By.cssSelector("div[class='pull-left'] h2");
			
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		
	}

	public LoginPage getLogin() {
		driver.findElement(signin).click();
		LoginPage lop = new LoginPage(driver);
		return lop;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title); 
	}
	
	public WebElement getNavigationBar() {
		return driver.findElement(navigationBar); 
	}
	
	public WebElement getcourseHeader() {
		return driver.findElement(courseHeader);
	}

}
