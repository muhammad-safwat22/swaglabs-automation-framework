package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/*
 * Cart Page
 *
 * Responsible for:
 * - Viewing products in cart
 * - Removing products from cart
 * - Continuing shopping
 * - Proceeding to checkout
 */
public class CartPage extends PageBase {

	// Initialize Cart Page elements using PageFactory
	public CartPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Locators
	// =========================
	@FindBy(className = "title")
	private WebElement cartTitle;

	@FindBy(css = "#item_4_title_link > div")
	private WebElement productName;

	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeBtn;

	@FindBy(id = "continue-shopping")
	private WebElement continueBtn;

	@FindBy(id = "checkout")
	private WebElement checkoutBtn;

	// =========================
	// Actions
	// =========================
	public String getCartTitle() {
		return cartTitle.getText();
	}

	public String getProductName() {
		return productName.getText();
	}

	public void clickRemove() {
		removeBtn.click();
	}

	public void clickContinue() {
		continueBtn.click();
	}

	public void clickCheckout() {
		checkoutBtn.click();
	}

	// Returns false if the product is removed from the cart.
	public boolean isProductNameDisplayed() {

		try {
			return productName.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
