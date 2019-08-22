package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory {
	
	@FindBy(how = How.XPATH, using = "//input[@name='emailid']")
	private WebElement emailTextbox;
	
	@FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
	private WebElement submitButton;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'User ID')]/following-sibling::td")
	private WebElement userIDText;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Password')]/following-sibling::td")
	private WebElement passwordText;
	
	WebDriver driver;
	public RegisterPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inputToEmailTextbox(String email) {
		emailTextbox.sendKeys(email);
	}

	public void clickToSubmitButton() {
		submitButton.click();
	}

	public String getUsernameInfo() {
		return userIDText.getText().trim();
	}

	public String getPasswordInfo() {
		return passwordText.getText().trim();
	}

	public void openLoginPageUrl(String loginPageUrl) {
		driver.get(loginPageUrl);	
	}
	
}
