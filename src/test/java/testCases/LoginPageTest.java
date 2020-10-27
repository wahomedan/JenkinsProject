package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.LoginPage;



public class LoginPageTest extends TestBase {
	LoginPage loginpageObj;


	@BeforeMethod
	public void setUp() {
		initializeDriver();
		loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	}

	@Test(priority=1)
	public void loginTest() throws Throwable {
		loginpageObj.enterUserName(prop.getProperty("userName"));		
		Thread.sleep(2000);

		loginpageObj.enterPassword(prop.getProperty("userPassword"));
		Thread.sleep(2000);
		
		loginpageObj.clickSignInButton();
		
		takeScreenshotAtEndOfTest();
	}

	@Test(priority=2)
	public void loginpageTitleTest() throws  Throwable{
		loginpageObj.enterUserName(prop.getProperty("userName"));	
		Thread.sleep(2000);
		loginpageObj.enterPassword(prop.getProperty("userPassword"));
		Thread.sleep(2000);
		loginpageObj.clickSignInButton();
		
		String expectedTitle="Dashboard- iBilling";
		String actualTitle=loginpageObj.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(actualTitle);	
	}

	@AfterMethod
	public void tearDown() {		
		driver.close();
		driver.quit();
	}

}
