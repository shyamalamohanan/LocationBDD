package steps;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.messages.internal.com.google.protobuf.util.Durations;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HooksImplementation extends BaseClass{
	
	@Before
	public void precondition(){
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		options.addArguments("start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		js = (JavascriptExecutor)driver;
		
		waitFluent = new FluentWait<WebDriver>(driver);
		((FluentWait<WebDriver>) waitFluent).withTimeout(Duration.ofSeconds(60));
		((FluentWait<WebDriver>) waitFluent).pollingEvery(Duration.ofSeconds(5));
		((FluentWait<WebDriver>) waitFluent).ignoring(Exception.class);
		
	}

	@After
	public void postcondition() {
		driver.close();

	}
}
