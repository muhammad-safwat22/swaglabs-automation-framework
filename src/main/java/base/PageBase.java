package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Base Page Class
 *
 * Responsible for:
 * - Storing WebDriver instance
 * - Initializing PageFactory elements
 * - Providing common functionality for all pages
 */
public class PageBase {
	protected WebDriver driver;
	protected WebDriverWait wait;

	// Initialize page elements using PageFactory
	public PageBase(WebDriver driver) {
		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		PageFactory.initElements(driver, this);
	}

	// Wait until element becomes visible
	protected void waitForVisibility(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait until element becomes clickable
	protected void waitForClickability(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
