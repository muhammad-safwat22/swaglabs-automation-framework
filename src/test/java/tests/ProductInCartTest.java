package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Constants;

/*
 * Product In Cart Test
 * Verify product remains available in cart
 * before proceeding to checkout.
 */
public class ProductInCartTest extends TestBase {

	/*
	 * Verify user can add, remove, re-add a product and proceed to checkout
	 * successfully.
	 */
	@Test
	public void productInCart() {

		loginAsStandardUser();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);

		productsPage.clickShoppingCart();

		Assert.assertEquals(cartPage.getCartTitle(), Constants.CART_TITLE);

		Assert.assertEquals(cartPage.getProductName(), Constants.PRODUCT_NAME);

		cartPage.clickRemove();

		Assert.assertFalse(cartPage.isProductNameDisplayed());

		cartPage.clickContinue();

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);

		productsPage.clickShoppingCart();

		Assert.assertEquals(cartPage.getCartTitle(), Constants.CART_TITLE);

		Assert.assertEquals(cartPage.getProductName(), Constants.PRODUCT_NAME);

		cartPage.clickCheckout();

		Assert.assertEquals(checkoutPage.getCheckoutTitle(), Constants.CHECKOUT_INFORMATION_TITLE);
	}
}