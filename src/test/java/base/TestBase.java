package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import models.CheckoutData;
import models.UserCredentials;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;
import utilities.ConfigReader;
import utilities.JsonDataReader;

/*
 * Base Test Class
 *
 * Responsible for:
 * - Browser initialization
 * - Browser configuration
 * - Navigation to application URL
 * - Browser cleanup after each test
 */
public class TestBase {
	// Shared WebDriver instance for all test classes
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected ProductsPage productsPage;
	protected CartPage cartPage;
	protected CheckoutPage checkoutPage;
	protected CheckoutOverviewPage checkoutOverviewPage;
	protected CheckoutCompletePage checkoutCompletePage;
	protected JsonDataReader testData;

	@BeforeMethod
	public void setUp() {
		// WebDriverManager.edgedriver().setup();
		String browser = ConfigReader.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();

		driver.get(ConfigReader.getProperty("baseUrl"));

		loginPage = new LoginPage(driver);

		productsPage = new ProductsPage(driver);

		cartPage = new CartPage(driver);

		checkoutPage = new CheckoutPage(driver);

		checkoutOverviewPage = new CheckoutOverviewPage(driver);

		checkoutCompletePage = new CheckoutCompletePage(driver);

		testData = new JsonDataReader();

	}

	protected void loginAsStandardUser() {

		UserCredentials validUser = testData.getValidUser();

		loginPage.login(validUser.getUsername(), validUser.getPassword());
	}

	protected void loginAsInvalidUser() {

		UserCredentials invalidUser = testData.getInvalidUser();

		loginPage.login(invalidUser.getUsername(), invalidUser.getPassword());
	}

	protected void enterCheckoutInformation() {

		CheckoutData checkoutData = testData.getCheckoutData();

		checkoutPage.enterCheckoutInformation(checkoutData.getFirstName(), checkoutData.getLastName(),
				checkoutData.getPostalCode());
	}

	protected void enterCheckoutInformationFirstName() {

		CheckoutData checkoutData = testData.getCheckoutData();

		checkoutPage.enterFirstName(checkoutData.getFirstName());
	}

	protected void enterCheckoutInformationLastName() {

		CheckoutData checkoutData = testData.getCheckoutData();

		checkoutPage.enterLastName(checkoutData.getLastName());
	}

	@AfterMethod
	public void tearDown() {
		// Prevent NullPointerException if browser initialization fails
		if (driver != null) {
			driver.quit();
		}
	}
}
