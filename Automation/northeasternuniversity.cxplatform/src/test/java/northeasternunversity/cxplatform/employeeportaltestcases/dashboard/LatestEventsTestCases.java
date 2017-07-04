package northeasternunversity.cxplatform.employeeportaltestcases.dashboard;

import northeasternuniversity.cxplatform.pages.general.*;
import northeasternuniversity.cxplatform.webdriver.*;
import northeasternuniversity.cxplatform.constants.*;
import northeasternuniversity.cxplatform.pages.staffemployeeportal.*;
import northeasternuniversity.cxplatform.utilities.DateChecker;
import northeasternuniversity.cxplatform.utilities.PageChecker;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LatestEventsTestCases {

	LoginPage loginPage;
	HomePage homePage;

	WebDriverManager driverManager;
	UIElementsPropertiesManager UIElementsPropertiesManager;
	ConstantsPropertiesManager constantsPropertiesManager;
	DataSourceManager dataSourceManager;
	PageChecker pageChecker;
	DateChecker dateChecker;

	int userNameIndex;
	int passwordIndex;
	String userName;
	String password;
	String expectedURLForViewLatestEventsPage;

	@BeforeTest
	public void beforeTest() {
		this.driverManager = new WebDriverManager();
		this.UIElementsPropertiesManager = new UIElementsPropertiesManager(FilesLocations.UIELEMENTSPROPERTIESFILEPATH);
		this.constantsPropertiesManager = new ConstantsPropertiesManager(FilesLocations.CONSTANTSPROPERTIESFILEPATH);

		this.dataSourceManager = new DataSourceManager(FilesLocations.TESTUSERSDATASOURCEFILEPATH,
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("dataSheetNameTestUsers"),
				Integer.parseInt(
						constantsPropertiesManager.getSharedExecutionConstants().getProperty("dataRowIndexTestUser")));

		this.loginPage = new LoginPage(driverManager, UIElementsPropertiesManager);
		this.homePage = new HomePage(driverManager, UIElementsPropertiesManager, constantsPropertiesManager);
		this.pageChecker = new PageChecker();
		this.dateChecker = new DateChecker();

		int userNameIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("userNameIndex"));
		int passwordIndex = Integer
				.parseInt(constantsPropertiesManager.getSharedExecutionConstants().getProperty("passwordIndex"));

		this.userName = dataSourceManager.getDataValue(userNameIndex);
		this.password = dataSourceManager.getDataValue(passwordIndex);

		this.dataSourceManager = new DataSourceManager(FilesLocations.TESTUSERSDATASOURCEFILEPATH,
				"OptionsAndExpectedURLS", 1);
		this.dataSourceManager.setTestDataRow(16);
		this.expectedURLForViewLatestEventsPage = dataSourceManager.getDataValue(1);
		dataSourceManager.closeIO();
	}

	@Test(priority = 1)
	public void NUCP82() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-82:" + "\n"
				+ "Summary: Verify that the application redirects to the “Events Page” page when “View All Events” link is clicked on the Events section of Dashboard");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		homePage.goToHomePage();

		loginPage.getDriverManager().driverLongWait();

		// Verifying if we are positioned on the landing page
		Assert.assertTrue(homePage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));
		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverShortWait();

		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(homePage.isLatestEventsPortletPresent());
		Assert.assertTrue(homePage.isViewLatestEventsPageLinkPresent());

		WebElement viewLatestEventsPageLinkElement = homePage.getViewAllEventsPageElement();

		Assert.assertTrue(homePage.hyperLinkHasTargetBlankAttribute(viewLatestEventsPageLinkElement));
		Assert.assertEquals(viewLatestEventsPageLinkElement.getAttribute("href"), expectedURLForViewLatestEventsPage);

		Assert.assertTrue(pageChecker.isSuccessResponse(viewLatestEventsPageLinkElement.getAttribute("href")));

	}

	@Test(priority = 2)
	public void NUCP81() {

		// JIRA test case ID & Description for Automated Test Case
		System.out.println("Test Case NUCP-81:" + "\n"
				+ "Summary: Verify that the application redirects to the proper page when a link is clicked on the Events section of Dashboard");

		loginPage.setCredentials(userName, password);
		loginPage.loginClick();
		homePage.goToHomePage();

		loginPage.getDriverManager().driverLongWait();

		// Verifying if we are positioned on the landing page
		Assert.assertTrue(homePage.getDriver().getCurrentUrl().equals(
				constantsPropertiesManager.getSharedExecutionConstants().getProperty("northeastern.edu_homepageurl")));
		// Waiting for the web browser, it should loads all the elements on the
		// DOM
		homePage.getDriverManager().driverShortWait();

		// Verifying if the Element to be clicked is present on the DOM
		Assert.assertTrue(homePage.isLatestEventsPortletPresent());
		Assert.assertTrue(homePage.isLatestEventsPortletDivContainerPresent());
		Assert.assertTrue(homePage.hasLastesEventsLinks());

		if (homePage.hasLastesEventsLinks()) {
			homePage.getDriverManager().driverLongWait();
			List<WebElement> LatestEventsList = homePage.getAllElementsOnLatestEventsPortlet();

			for (WebElement divParentElement : LatestEventsList) {
				WebElement hyperLinkElement = divParentElement.findElement(By.xpath("div/div/a"));

				Assert.assertTrue(homePage.hyperLinkHasTargetBlankAttribute(hyperLinkElement));
				// pageChecker.printHttpResponse(AppNameLinkElement.getAttribute("href"));
				Assert.assertTrue(pageChecker.isSuccessResponse(hyperLinkElement.getAttribute("href")));

				WebElement LatestEventMonthElement = divParentElement
						.findElement(By.xpath("div/div[contains(@class,'card-date')]/p[@class='month']"));
				WebElement LatestEventDayElement = divParentElement
						.findElement(By.xpath("div/div[contains(@class,'card-date')]/p[@class='day']"));

				dateChecker.validateDayIsCorrect(LatestEventDayElement.getText());
				dateChecker.validateMonthIsCorrect(LatestEventMonthElement.getText());

			}
		}

	}

	@AfterTest
	public void afterTest() {
		driverManager.closeConnection();
	}
}
