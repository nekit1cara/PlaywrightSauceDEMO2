package org.example.Elements;

import lombok.Getter;

@Getter
public class LoginPageElements {

    private final String usernameField = "//input[@id = 'user-name']";
    private final String passwordField = "//input[@id = 'password']";
    private final String loginButton = "//input[@id = 'login-button']";
    private final String logo = "//div[@class = 'app_logo']";

}
