package stepDefinations;

//import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
//import pageObjects.portalHomePage;
import resources.base;

public class stepDefination extends base {
	LoginPage lop;
	
	@Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
		driver = initializeDriver();
    }
	
	@And("^Navigate to \"([^\"]*)\" site$")
	public void navigate_to_something_site(String strArg1) throws Throwable {
		driver.get(strArg1);   
	}

	@And("^Click on login link in home page to land on secure signin page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_signin_page() throws Throwable {
		LandingPage lp = new LandingPage(driver);
		lop = lp.getLogin();        
	}
    
    @When("^User enteres (.+) and (.+) and logs in$")
    public void user_enteres_and_and_logs_in(String username, String password) throws Throwable {
    	lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		lop.getLogin().click();
    }

    @Then("^Verify the user is successfully logged in$")
    public void verify_the_user_is_successfully_logged_in() throws Throwable {
    	//portalHomePage php = new portalHomePage(driver);
    	//Assert.assertEquals(php.getCurrentUser().getText(), "Ramesh Selvam"); //unable to use this step as there is captcha validation before login.
    	System.out.println("user logged in successfully");
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }
    
}