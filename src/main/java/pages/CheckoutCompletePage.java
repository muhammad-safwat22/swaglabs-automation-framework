package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/*
 * Checkout Complete Page
 *
 * Responsible for:
 * - Verifying successful order placement
 * - Reading success confirmation message
 * - Navigating back to products page
 */
public class CheckoutCompletePage extends PageBase {

	// Initialize Checkout Complete Page elements using PageFactory
	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Locators
	// =========================
	@FindBy(className = "title")
	private WebElement checkoutCompleteTitle;

	@FindBy(className = "complete-header")
	private WebElement successMsg;

	@FindBy(id = "back-to-products")
	private WebElement backHomeBtn;

	// =========================
	// Actions
	// =========================
	public String getCheckoutCompleteTitle() {
		return checkoutCompleteTitle.getText();
	}

	public String getSuccessMsg() {
		return successMsg.getText();
	}

	public void clickBackHome() {
		backHomeBtn.click();
	}

}
