package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException, InterruptedException { 
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage lop = lp.getLogin(); 
		
		lop.getEmail().sendKeys(Username);
		lop.getPassword().sendKeys(Password);
		//System.out.println(text);
		//lop.getLogin().click();
		log.info(text);
		
		ForgotPassword fp = lop.forgotPassowrd();
		fp.getEmail().sendKeys("abc");
		fp.sendMeInstructions().click();
	}
	
	@AfterTest
	public void teardown() {
		driver.close(); 
	}
		
	@DataProvider
	public Object[][] getData() {
		
		//Row stands different data types that the test should run.
		//Column stands for how many values per test.
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		data[0][2] = "Non restricted user";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "67892";
		data[1][2] = "Restricted user";
		
		return data;
	}
	
}
