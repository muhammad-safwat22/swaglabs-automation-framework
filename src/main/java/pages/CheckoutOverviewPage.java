package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/*
 * Checkout Overview Page
 *
 * Responsible for:
 * - Reviewing order details
 * - Validating payment information
 * - Validating shipping information
 * - Validating total price
 * - Completing or canceling checkout
 */
public class CheckoutOverviewPage extends PageBase {

	// Initialize Checkout Overview Page elements using PageFactory
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Locators
	// =========================
	@FindBy(className = "title")
	private WebElement checkoutOverviewTitle;

	@FindBy(css = "#item_4_title_link > div")
	private WebElement productName;

	@FindBy(css = "div.summary_info > div:nth-child(1)")
	private WebElement paymentInfo;

	@FindBy(css = "div.summary_info > div:nth-child(3)")
	private WebElement shippingInfo;

	@FindBy(css = "div.summary_info > div:nth-child(5)")
	private WebElement priceTotal;

	@FindBy(id = "cancel")
	private WebElement cancelBtn;

	@FindBy(id = "finish")
	private WebElement finishBtn;

	// =========================
	// Actions
	// =========================
	public String getCheckoutOverviewTitle() {
		return checkoutOverviewTitle.getText();
	}

	public String getProductName() {
		return productName.getText();
	}

	public String getPaymentInfo() {
		return paymentInfo.getText();
	}

	public String getShippingInfo() {
		return shippingInfo.getText();
	}

	public String getPriceTotal() {
		return priceTotal.getText();
	}

	public void clickCancel() {
		cancelBtn.click();
	}

	public void clickFinish() {
		finishBtn.click();
	}

}