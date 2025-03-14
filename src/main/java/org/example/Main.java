package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.Configuration.ConfigReader;

public class Main {

    private static Playwright playwright;
    private static Browser browser;
    public static Page page;

    public static void main(String[] args) {

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
            page.navigate("https://www.saucedemo.com/v1/");

            String username = ConfigReader.getProperty("username");
            String password = ConfigReader.getProperty("password");

            if (username == null || password == null) {
                throw new RuntimeException("Username or password is null. Check ConfigReader.");
            }

            String usernameField = "#user-name";
            String passwordField = "#password";
            String loginButton = "#login-button";
            String logo = ".app_logo";

            page.waitForSelector(usernameField);
            page.fill(usernameField, username);

            page.waitForSelector(passwordField);
            page.fill(passwordField, password);

            page.waitForSelector(loginButton);
            page.click(loginButton);

            page.waitForSelector(logo);

            if (!page.isVisible(logo)) {
                throw new RuntimeException("Logo is not visible");
            } else {
                System.out.println(page.getAttribute(logo, "class"));
            }

            playwright.close();

    }
}
