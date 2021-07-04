package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Given;

public class HomePage extends BaseClass{

	@Given("Click on App Launcher in the Left corner")
	public void click_on_app_launcher_in_the_left_corner() {		
		WebElement eleToggleButton = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.elementToBeClickable(eleToggleButton));
		eleToggleButton.click();
	}

	@Given("Click View All")
	public void click_view_all() {
		WebElement eleViewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		eleViewAll.click();
	}

	@Given("Click on Locations under All items")
	public void click_on_locations_under_all_items() {
		WebElement eleLocations = driver.findElement(By.xpath("//p[text()='Locations']"));
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", eleLocations);
	    
	}
}
