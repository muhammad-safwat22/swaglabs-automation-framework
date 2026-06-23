package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.Constants;

/*
 * Login Test Suite
 *
 * Covers:
 * - Valid login scenario
 * - Invalid login scenario
 */
public class LoginTest extends TestBase {

	// Verify user can login with valid credentials
	@Test(priority = 1)
	public void validLogin() {

		loginAsStandardUser();

		Assert.assertEquals(productsPage.getPageTitle(), Constants.PRODUCTS_TITLE);
	}

	// Verify error message is displayed for invalid credentials
	@Test(priority = 2)
	public void invalidLogin() {

		loginAsInvalidUser();

		Assert.assertEquals(loginPage.getErrorMsg(), Constants.ERROR_MESSAGE_LOGIN_PAGE);
	}
}