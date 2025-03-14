package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.Configuration.ConfigReader;
import org.example.Pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTests {

    public HomePage homePage;
    public Playwright playwright = Playwright.create();
    public BrowserType chromium = playwright.chromium();
    public Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
    public Page page = browser.newPage();


    @BeforeTest
    public void setUp() {
        page.navigate(ConfigReader.getProperty("mainUrl"));
        this.homePage = new HomePage(page);

    }

    @Test(priority = 1)
    public void verifyHeaderIsDisplayed() {
        homePage.checkHeaderIsVisible();
    }

    @Test(priority = 2)
    public void verifyFooterIsDisplayed() {
        homePage.checkFooterIsVisible();
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
