package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class loginTest {
	WebDriver driver;

	@Given("^Open Chrome browser and application$")
	public void open_Chrome_browser_and_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

	}

	@When("^I enter valid \"([^\"]*)\" and valid \"([^\"]*)\"$")
	public void i_enter_valid_and_valid(String arg1, String arg2) throws Throwable {
		WebElement username = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.xpath("//*[@id='pass']"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit'][1]"));
		username.sendKeys("vishalrathi910@gmail.com");
		password.sendKeys("vishalisgood@725769725769");
		loginButton.click();

	}

	@Then("^Sucessfully login into facebook$")
	public void sucessfully_login_into_facebook() throws Throwable {
		String expectedTitle = "Facebook";
		WebDriverWait wait = new WebDriverWait(driver, 100);

		wait.until(ExpectedConditions.titleContains("Facebook"));

		String pageTitle = driver.getTitle();

		Assert.assertEquals(pageTitle, expectedTitle);
	}

}
