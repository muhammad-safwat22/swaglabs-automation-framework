package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Constants;

/*
 * Remove Product From Cart Test
 * Verify user can remove a product from the cart
 * and add it again successfully.
 */
public class RemoveProductFromCartTest extends TestBase {

	// Verify user can remove a product from the cart and add it again successfully.
	@Test
	public void removeProductFromCart() {

		loginAsStandardUser();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);

		productsPage.clickRemove();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		Assert.assertFalse(productsPage.isCartBadgeDisplayed());

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);
	}
}