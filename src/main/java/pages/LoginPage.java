package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

/*
 * Login Page
 *
 * Responsible for:
 * - User authentication
 * - Entering login credentials
 * - Submitting login request
 * - Reading login error messages
 */
public class LoginPage extends PageBase {

	// Initialize Login Page elements using PageFactory
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// =========================
	// Locators
	// =========================
	@FindBy(id = "user-name")
	private WebElement usernameTxt;

	@FindBy(id = "password")
	private WebElement passwordTxt;

	@FindBy(id = "login-button")
	private WebElement loginBtn;

	@FindBy(css = "h3[data-test='error']")
	private WebElement errorMsg;

	// =========================
	// Actions
	// =========================
	public void enterUsername(String username) {
		usernameTxt.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordTxt.sendKeys(password);
	}

	public void clickLoginButton() {
		loginBtn.click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public String getErrorMsg() {
		return errorMsg.getText();
	}
}
