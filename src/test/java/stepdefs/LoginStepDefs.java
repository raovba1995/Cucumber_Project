package stepdefs;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
	
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Hooks.test.log(LogStatus.PASS, "Application Launched");

	}

	@Given("I click on login link")
	public void i_click_on_login_link() {
		// Write code here that turns the phrase above into concrete actions
		WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		LoginLink.click();
		Hooks.test.log(LogStatus.PASS, "Clicked on Login Link");


	}

	@When("I enter username")
	public void i_enter_username() {
		// Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		Hooks.test.log(LogStatus.PASS, "Entered the Username ");

	}

	@When("I enter the password")
	public void i_enter_the_password() {
		// Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abc@1234");
		Hooks.test.log(LogStatus.PASS, "Entered the Password ");

	}

	@When("I click on login button")
	public void i_click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		LoginBtn.click();

	}

	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expMsg) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Error = driver.findElement(By.className("error_msg"));
		String actMsg = Error.getText();
		Assert.assertEquals(expMsg, actMsg);
		

	}
	
	@When("I enter username as {string}")
	public void i_enter_username_as(String UserNameVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UserNameVal);
		Hooks.test.log(LogStatus.PASS, "Entered the Username " + UserNameVal);
	    
	}

	@When("I enter the password as {string}")
	public void i_enter_the_password_as(String PasswordVal) {
	    // Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordVal);
		Hooks.test.log(LogStatus.PASS, "Entered the Password " + PasswordVal);

	}

	@Then("I see the below login options present on the screen")
	public void i_see_the_below_login_options_present_on_the_screen(List<String> loginOptions) {
	    
		for (String option : loginOptions) {

			WebElement otherOptions = driver.findElement(By.xpath("//span[text()='" + option + "']"));
			Assert.assertTrue(otherOptions.isDisplayed());
		}

	}


}
