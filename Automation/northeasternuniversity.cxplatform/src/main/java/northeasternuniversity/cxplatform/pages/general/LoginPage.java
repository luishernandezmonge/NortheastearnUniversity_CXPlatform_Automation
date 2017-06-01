/**
 * 
 */
package northeasternuniversity.cxplatform.pages.general;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import northeasternuniversity.cxplatform.constants.UIElementsPropertiesManager;
import northeasternuniversity.cxplatform.webdriver.WebDriverManager;


/**
 * @author luishernandez
 *
 */

public class LoginPage {

	private WebDriverManager driverManager;
	private UIElementsPropertiesManager uIElementsManager;
	private WebDriver driver;

	private String userNameTextBoxLocator;
	private String passwordTextBoxLocator;
	private String loginButtonLocator;
	private String signInLinkLocator;

	/**
	 * 
	 */
	public LoginPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driverManager.openConnection();
		this.uIElementsManager = UIElementsPropertiesManager;
		this.driver = this.driverManager.getDriver();
		
	    signInLinkLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("northeastern.edu.signinpage.sigin_link");
		signInClick();
		
		this.driverManager.driverShortWait();	
	    userNameTextBoxLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("northeasternn.edu.signinpage.txtbox_UserName");
		passwordTextBoxLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("northeasternn.edu.signinpage.txtbox_Password");
		loginButtonLocator = uIElementsManager.getSharedUIElementsLocators().getProperty("northeasternn.edu.signinpage.btn_Login");
	}

	public void setCredentials(String usernameValue, String passwordValue) {
		
		WebElement userNameWebElement = driver.findElement(By.xpath(userNameTextBoxLocator));
		userNameWebElement.clear();
		userNameWebElement.sendKeys(usernameValue);

		WebElement passwordWebElement = driver.findElement(By.xpath(passwordTextBoxLocator));
		passwordWebElement.clear();
		passwordWebElement.sendKeys(passwordValue);
	}

	public void signInClick(){
		this.driverManager.driverShortWait();
		WebElement signInLinkELement = driver.findElement(By.xpath(signInLinkLocator));
		signInLinkELement.click();
	}
	
	public void loginClick() {
		this.driverManager.driverLongWait();
		WebElement loginButtonWebElement = driver.findElement(By.xpath(loginButtonLocator));
		loginButtonWebElement.submit();
	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	public void setDriverManager(WebDriverManager driverManager) {
		this.driverManager = driverManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	

}
