package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LocationPage extends BaseClass {

	@Given("Enter Search Location as {string}")
	public void enter_search_location(String location) throws InterruptedException {
	    WebElement eleSearch = driver.findElement(By.xpath("//input[@placeholder='Search this list...']"));
	    wait.until(ExpectedConditions.visibilityOf(eleSearch));
	    eleSearch.sendKeys(location,Keys.ENTER);
	    Thread.sleep(4000);
	}

	@Given("Click on Locations Name link")
	public void click_on_locations_name_link() {
	    WebElement eleLocLink = driver.findElement(By.xpath("//table[@role='grid']//tbody//tr/th//child::a"));
	    waitFluent.until(ExpectedConditions.visibilityOf(eleLocLink));
	    eleLocLink.click();
	}

	@Given("Click right side Corner DropDown")
	public void click_right_side_corner_drop_down() {
	    	WebElement eleDropDown = driver.findElement(By.xpath("//li[@data-aura-class='oneActionsDropDown']"));
	    	wait.until(ExpectedConditions.visibilityOf(eleDropDown));
	    	eleDropDown.click();
	}

	@Given("Select Clone")
	public void select_clone() {
	    WebElement eleClone = driver.findElement(By.xpath("//li[@role='presentation']//a[@title='Clone']"));
	    eleClone.click();
	}

	@Given("Enter the External References")
	public void enter_the_external_references(){
	    WebElement eleExtRef = driver.findElement(By.xpath("//span[text()='External Reference']//following::input"));
	    wait.until(ExpectedConditions.visibilityOf(eleExtRef));
	    eleExtRef.clear();
	    eleExtRef.sendKeys("Personal Trip");
	}
	
	@Given("Change the External References")
	public void change_the_external_references() {
		WebElement eleExtRef = driver.findElement(By.xpath("(//span[text()='External Reference']//following::input)[2]"));
	    wait.until(ExpectedConditions.visibilityOf(eleExtRef));
	    eleExtRef.clear();
	    eleExtRef.sendKeys("Personal Trip");
	}


	@When("Click on Save")
	public void click_on_save() {
	    WebElement eleSave = driver.findElement(By.xpath("//button[@type='button'][@title='Save']"));
	    eleSave.click();
	}

	@Then("Verify the  External References is Changed")
	public void verify_the_external_references_is_changed() {
		WebElement eleMsgBanner = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']"));
		String actualMsgBanner = wait.until(ExpectedConditions.visibilityOf(eleMsgBanner)).getText();
		String expectedMsgBanner = "Location \"Coimbatore\" was created." ;
		
	Assert.assertEquals(actualMsgBanner, expectedMsgBanner, "The Location was not cloned - please verify!!");	    
	}
	
	@Given("Click on New")
	public void click_on_new() {
	    WebElement eleNew = driver.findElement(By.xpath("//a[@role='button']//div[@title='New']"));
	    wait.until(ExpectedConditions.visibilityOf(eleNew));
	    eleNew.click();
	}

	@Given("Enter the Location Name As Any name")
	public void enter_the_location_name_as_any_name() {
		WebElement eleLocName = driver.findElement(By.xpath("((//span[text()='Location Name'])[2]//following::input)[1]"));
		waitFluent.until(ExpectedConditions.visibilityOf(eleLocName));
		eleLocName.sendKeys("Madurai");
	}

	@Given("Choose Location Type as any type")
	public void choose_location_type_as_any_type() {
		WebElement eleLocTypeDD = driver.findElement(By.xpath("//a[@class='select']"));
		eleLocTypeDD.click();
		WebElement eleLocType = driver.findElement(By.xpath("//li[@role='presentation']//a[@title='Site']"));
		eleLocType.click();
	}

	@When("Click on Cancel")
	public void click_on_cancel() {
		WebElement eleCancel = driver.findElement(By.xpath("//button[@title='Cancel']"));
		eleCancel.click();
	    
	}

	@Then("Verify if the Locations is Cancelled")
	public void verify_if_the_locations_is_cancelled() {
		WebElement eleNoItemsMsg = driver.findElement(By.xpath("//span[text()='No items to display.']"));
		String actualNoItemsMsg = wait.until(ExpectedConditions.visibilityOf(eleNoItemsMsg)).getText();
		String expectedNoItemsMsg = "No items to display.";
		
		Assert.assertEquals(actualNoItemsMsg, expectedNoItemsMsg, "The given Location is present. Kindly verify!!");
	    
	}


}
