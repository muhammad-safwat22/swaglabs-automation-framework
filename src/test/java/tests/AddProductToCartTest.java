package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Constants;

/*
 * Add Product To Cart Test
 * Verify user can add a product to the shopping cart.
 */
public class AddProductToCartTest extends TestBase {

	// Verify cart badge count is updated after adding a product.
	@Test
	public void addProductToCart() {

		loginAsStandardUser();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);
	}
}