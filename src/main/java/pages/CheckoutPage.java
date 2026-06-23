package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/*
 * Checkout Information Page
 *
 * Responsible for:
 * - Entering customer information
 * - Navigating to checkout overview
 * - Returning to cart page
 */
public class CheckoutPage extends PageBase {

	// Initialize Checkout Page elements using PageFactory
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Locators
	// =========================
	@FindBy(className = "title")
	private WebElement checkoutTitle;

	@FindBy(id = "first-name")
	private WebElement firstNameTxt;

	@FindBy(id = "last-name")
	private WebElement lastNameTxt;

	@FindBy(id = "postal-code")
	private WebElement zipPostalCodeTxt;

	@FindBy(id = "continue")
	private WebElement continueBtn;

	@FindBy(id = "cancel")
	private WebElement cancelBtn;

	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMsg;

	// =========================
	// Actions
	// =========================
	public String getCheckoutTitle() {
		return checkoutTitle.getText();
	}

	public void enterFirstName(String firstName) {
		firstNameTxt.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNameTxt.sendKeys(lastName);
	}

	public void enterZipPostalCode(String postalCode) {
		zipPostalCodeTxt.sendKeys(postalCode);
	}

	public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterZipPostalCode(postalCode);
	}

	public void clickContinue() {
		continueBtn.click();
	}

	public void clickCancel() {
		cancelBtn.click();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}

}
