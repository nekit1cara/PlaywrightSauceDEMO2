package org.example.Configuration;
import com.microsoft.playwright.*;
import lombok.Getter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;


public class PlaywrightConfig {

    protected static Playwright playwright;
    protected static Browser browser;

    @Getter
    protected static Page page;

    @BeforeAll
    public static void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @AfterAll
    public static void tearDown() {
        if (playwright != null) {
            playwright.close();
        }
    }

}
