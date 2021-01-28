package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base {
	public WebDriver driver;
	LandingPage lp;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test
	public void validateAppTitle() throws IOException { 
		lp = new LandingPage(driver);
		String actualTitle = lp.getTitle().getText();
		Assert.assertTrue(actualTitle.contains("World class"));
		log.info("Successfully validated text message");
	}
	
	@Test
	public void validateHeader() {
		 Assert.assertEquals(lp.getcourseHeader().getText(), "Featured Courses"); 
	}
	
	@AfterTest
	public void teardown() {
		driver.close(); 
	}
	
}
