package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.Configuration.ConfigReader;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest {

    LoginPage loginPage;
    HomePage homePage;
    Playwright playwright = Playwright.create();
    BrowserType chromium = playwright.chromium();
    Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
    Page page = browser.newPage();


    @BeforeTest
    public void setUp() {
        page.navigate(ConfigReader.getProperty("baseUrl"));
        loginPage = new LoginPage(page);
        homePage = new HomePage(page);
    }


    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = loginPage.verifyTitle();
        Assert.assertEquals(title, "Swag Labs");
    }

    @Test(priority = 2)
    public void loginIntoTheApplication() {
        loginPage.loginIntoApplication();
    }

    @Test(priority = 3)
    public void verifyProductName() {
       homePage.getProductNameAndVerifyIt();
    }

    @Test(priority = 4)
    public void logoutFromTheApplication() {
        homePage.logoutApplication();
    }


    @AfterTest
    public void closeBrowser() {
        browser.close();
    }
}
