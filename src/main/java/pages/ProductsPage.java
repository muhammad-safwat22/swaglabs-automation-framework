package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/*
 * Products Page
 *
 * Responsible for:
 * - Displaying available products
 * - Adding products to cart
 * - Removing products from cart
 * - Navigating to shopping cart
 * - Validating cart badge status

 * Expected Exception
 * → Handle it
 * Unexpected Exception
 * → Throw RuntimeException
 */
public class ProductsPage extends PageBase {

	// Initialize Products Page elements using PageFactory
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Locators
	// =========================
	@FindBy(className = "title")
	private WebElement productsTitle;

	@FindBy(css = "#item_4_title_link > div")
	private WebElement backpackProduct;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	private WebElement addToCartBtn;

	@FindBy(className = "shopping_cart_badge")
	private WebElement cartBadge;

	@FindBy(id = "remove-sauce-labs-backpack")
	private WebElement removeBtn;

	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartBtn;

	// =========================
	// Actions
	// =========================
	public String getPageTitle() {
		return productsTitle.getText();
	}

	public String getProductName() {
		return backpackProduct.getText();
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

	public String getCartBadgeCount() {
		return cartBadge.getText();
	}

	public void clickRemove() {
		removeBtn.click();
	}

	// Returns false if cart badge is not present after removing products
	public boolean isCartBadgeDisplayed() {

		try {
			return cartBadge.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void clickShoppingCart() {
		shoppingCartBtn.click();
	}
}
