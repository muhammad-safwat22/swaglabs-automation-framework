package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Constants;

/*
 * Checkout Test Suite
 * Covers:
 * - Successful checkout workflow
 * - Checkout validation scenarios
 */
public class CheckoutTest extends TestBase {

	/*
	 * Verify user can complete checkout information and navigate to checkout
	 * overview page.
	 */
	@Test(priority = 1)
	public void correctCheckout() {

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

		enterCheckoutInformation();

		checkoutPage.clickCancel();

		Assert.assertEquals(cartPage.getCartTitle(), Constants.CART_TITLE);

		Assert.assertEquals(cartPage.getProductName(), Constants.PRODUCT_NAME);

		cartPage.clickCheckout();

		Assert.assertEquals(checkoutPage.getCheckoutTitle(), Constants.CHECKOUT_INFORMATION_TITLE);

		enterCheckoutInformation();

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutOverviewPage.getCheckoutOverviewTitle(), Constants.CHECKOUT_OVERVIEW_TITLE);
	}

	// Verify required field validations on checkout information page.
	@Test(priority = 2)
	public void incorrectCheckout() {

		loginAsStandardUser();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);

		productsPage.clickShoppingCart();

		Assert.assertEquals(cartPage.getCartTitle(), Constants.CART_TITLE);

		Assert.assertEquals(cartPage.getProductName(), Constants.PRODUCT_NAME);

		cartPage.clickCheckout();

		Assert.assertEquals(checkoutPage.getCheckoutTitle(), Constants.CHECKOUT_INFORMATION_TITLE);

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutPage.getErrorMsg(), Constants.ERROR_MESSAGE_FIRST_NAME);

		driver.navigate().refresh();

		enterCheckoutInformationFirstName();

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutPage.getErrorMsg(), Constants.ERROR_MESSAGE_LAST_NAME);

		driver.navigate().refresh();

		enterCheckoutInformationFirstName();

		enterCheckoutInformationLastName();

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutPage.getErrorMsg(), Constants.ERROR_MESSAGE_POSTAL_CODE);
	}
}