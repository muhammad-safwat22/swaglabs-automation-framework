package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Constants;

/*
 * Complete Checkout Test
 * Verify user can successfully complete
 * the checkout process and return to products page.
 */
public class CompleteCheckoutTest extends TestBase {

	/*
	 * Verify complete checkout workflow including cancel, finish and back home
	 * actions.
	 */
	@Test
	public void completeCheckout() {

		loginAsStandardUser();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		productsPage.clickAddToCart();

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);

		productsPage.clickShoppingCart();

		Assert.assertEquals(cartPage.getCartTitle(), Constants.CART_TITLE);

		Assert.assertEquals(cartPage.getProductName(), Constants.PRODUCT_NAME);

		cartPage.clickCheckout();

		Assert.assertEquals(checkoutPage.getCheckoutTitle(), Constants.CHECKOUT_INFORMATION_TITLE);

		enterCheckoutInformation();

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutOverviewPage.getCheckoutOverviewTitle(), Constants.CHECKOUT_OVERVIEW_TITLE);

		Assert.assertEquals(checkoutOverviewPage.getProductName(), Constants.PRODUCT_NAME);

		Assert.assertEquals(checkoutOverviewPage.getPaymentInfo(), Constants.PAYMENT_INFORMATION_TITLE);

		Assert.assertEquals(checkoutOverviewPage.getShippingInfo(), Constants.SHIPPING_INFORMATION_TITLE);

		Assert.assertEquals(checkoutOverviewPage.getPriceTotal(), Constants.PRICE_TOTAL_TITLE);

		checkoutOverviewPage.clickCancel();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		Assert.assertEquals(productsPage.getCartBadgeCount(), Constants.CART_BADGE_COUNT);

		productsPage.clickShoppingCart();

		Assert.assertEquals(cartPage.getCartTitle(), Constants.CART_TITLE);

		Assert.assertEquals(cartPage.getProductName(), Constants.PRODUCT_NAME);

		cartPage.clickCheckout();

		Assert.assertEquals(checkoutPage.getCheckoutTitle(), Constants.CHECKOUT_INFORMATION_TITLE);

		enterCheckoutInformation();

		checkoutPage.clickContinue();

		Assert.assertEquals(checkoutOverviewPage.getCheckoutOverviewTitle(), Constants.CHECKOUT_OVERVIEW_TITLE);

		Assert.assertEquals(checkoutOverviewPage.getProductName(), Constants.PRODUCT_NAME);

		Assert.assertEquals(checkoutOverviewPage.getPaymentInfo(), Constants.PAYMENT_INFORMATION_TITLE);

		Assert.assertEquals(checkoutOverviewPage.getShippingInfo(), Constants.SHIPPING_INFORMATION_TITLE);

		Assert.assertEquals(checkoutOverviewPage.getPriceTotal(), Constants.PRICE_TOTAL_TITLE);

		checkoutOverviewPage.clickFinish();

		Assert.assertEquals(checkoutCompletePage.getCheckoutCompleteTitle(), Constants.CHECKOUT_COMPLETE_TITLE);

		Assert.assertEquals(checkoutCompletePage.getSuccessMsg(), Constants.SUCCESS_MESSAGE);

		checkoutCompletePage.clickBackHome();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);

		Assert.assertFalse(productsPage.isCartBadgeDisplayed());
	}
}