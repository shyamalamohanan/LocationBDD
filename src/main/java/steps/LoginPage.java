package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;

public class LoginPage extends BaseClass{
	
	@Given("Enter the UserName")
	public void enter_the_user_name() {
		WebElement eleUserName = driver.findElement(By.xpath("//input[@id='username']"));
		eleUserName.sendKeys("cypress@testleaf.com");
	}

	@Given("Enter the Password")
	public void enter_the_password() {
		WebElement eleUserPassword = driver.findElement(By.xpath("//input[@id='password']"));
		eleUserPassword.sendKeys("Selbootcamp@1234");
	}

	@Given("Click on the Login Button")
	public void click_on_the_login_button() {
		WebElement eleLoginButton = driver.findElement(By.xpath("//input[@id='Login']"));	
		eleLoginButton.click();
	}


}
