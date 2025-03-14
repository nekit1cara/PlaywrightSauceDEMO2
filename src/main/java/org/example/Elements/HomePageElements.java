package org.example.Elements;

import lombok.Getter;

@Getter
public class HomePageElements {


    private final String productName_1 = "//*[@id='item_4_title_link']/div";
    private final String appNavigateMenu = "//*[@id='menu_button_container']/div/div[3]/div/button";
    private final String logoutButton = "//a[@id = 'logout_sidebar_link']";
    private final String logo = "//div[@class = 'login_logo']";
}
