package org.example.Pages;

import com.microsoft.playwright.Page;
import org.example.Configuration.ConfigReader;
import org.example.Elements.LoginPageElements;

public class LoginPage {

    private final Page page;
    public LoginPageElements loginPageElements;

    public LoginPage(Page page ) {
        this.page = page;
        this.loginPageElements = new LoginPageElements();
    }

    public String verifyTitle() {
        return page.title();
    }

    public void loginIntoApplication() {
        String username = ConfigReader.getProperty("username");
        String password = ConfigReader.getProperty("password");
            page.fill(loginPageElements.getUsernameField(), username);
            page.fill(loginPageElements.getPasswordField(), password);
            page.click(loginPageElements.getLoginButton());

            if (page.isVisible(loginPageElements.getLogo())) {
                System.out.println("Login Successful!");
            }

    }

}

